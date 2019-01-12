package com.japa.Japa.dataAccess.entity;

import org.springframework.lang.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.springframework.util.ObjectUtils.isEmpty;

@Entity
@Table(name="User")
public class UserEntity implements UserDetails{
    @Id
    @Column (name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "USERNAME")
    private String username;

    @Column (name = "PASSWORD")
    private String password;

    @Column (name = "AUTHORITIES")
    private String authorities;

    @Column (name = "NON_EXPIRED")
    private Boolean non_expired;

    @Column (name = "NON_LOCKED")
    private Boolean non_locked;

    @Column (name = "CREDENTIALS_NON_EXPIRED")
    private Boolean credentials_non_expired;

    @Column (name = "ENABLED")
    private Boolean enabled;

    @Column
    private String first_name;

    @Column
    private String last_name;

    @Column
    private String email;

    @Column
    private String phone_number;

    @Column
    @Nullable
    private String favorite_manga_category;

    @Column
    private String address;

    /*@OneToMany(mappedBy = "user_id")
    private Collection<OrderEntity> orders;*/

    public UserEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return non_expired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return non_locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentials_non_expired;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        if(!isEmpty(authorities)) {
            String[] authoritiesAsArray = authorities.split(",");

            for(String authority : authoritiesAsArray) {
                if(!isEmpty(authority)) {
                    grantedAuthorities.add(new SimpleGrantedAuthority(authority));
                }
            }
        }
        return grantedAuthorities;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public Boolean isNon_expired() {
        return non_expired;
    }

    public void setNon_expired(Boolean non_expired) {
        this.non_expired = non_expired;
    }

    public Boolean isNon_locked() {
        return non_locked;
    }

    public void setNon_locked(Boolean non_locked) {
        this.non_locked = non_locked;
    }

    public Boolean isCredentials_non_expired() {
        return credentials_non_expired;
    }

    public void setCredentials_non_expired(Boolean credentials_non_expired) {
        this.credentials_non_expired = credentials_non_expired;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getFavorite_manga_category() {
        return favorite_manga_category;
    }

    public void setFavorite_manga_category(String favorite_manga_category) {
        this.favorite_manga_category = favorite_manga_category;
    }


/*public Collection<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(Collection<OrderEntity> orders) {
        this.orders = orders;
    }*/
}
