package com.japa.Japa.configuration;


import com.japa.Japa.controller.validator.UserValidator;
import com.japa.Japa.dataAccess.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.validation.Validator;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration  extends WebSecurityConfigurerAdapter{

    private static final String LOGIN_REQUEST = "/signin";
    private static final String[] AUTHORIZED_REQUESTS_ANYBODY = new String[]{"/signup", "/home/*", "/category/*", "product/*", "/cart/checkout", "cart/addProduct/*", "cart/minus/*", "cart/plus/*", "/css","/js", "/images"};
    private static final String[] AUTHORIZED_REQUESTS_CHECKOUT = new String[]{"/cart/validate", "/cart/bought"};

    private UserDetailsService userDetailsService;

    @Autowired
    public WebSecurityConfiguration(@Qualifier("userDetailsServiceImplementation") UserDetailsService userDetailsServiceImpl) {
        this.userDetailsService = userDetailsServiceImpl;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http
                .authorizeRequests()
                .antMatchers(AUTHORIZED_REQUESTS_CHECKOUT).authenticated()
                .antMatchers(AUTHORIZED_REQUESTS_ANYBODY).permitAll()

                .and()
                .formLogin()
                .successHandler(new SavedRequestAwareAuthenticationSuccessHandler())
                .defaultSuccessUrl("/home")
                .loginPage(LOGIN_REQUEST)
                .permitAll()

                .and()
                .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Bean
    @Autowired
    public Validator userValidator(UserDAO userDAO)
    {
        Validator bean = new UserValidator(userDAO);
        return bean;
    }
}
