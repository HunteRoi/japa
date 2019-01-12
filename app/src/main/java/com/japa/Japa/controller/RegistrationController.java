package com.japa.Japa.controller;

import com.japa.Japa.dataAccess.dao.CategoryDAO;
import com.japa.Japa.dataAccess.dao.UserDAO;
import com.japa.Japa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController{

    @Autowired
    @Qualifier("userValidator")
    private Validator validator;
    private CategoryDAO categoryDAO;
    private MessageSource messageSource;
    private UserDAO userDAO;

    @Autowired
    public RegistrationController (CategoryDAO categoryDAO, MessageSource messageSource, UserDAO userDAO) {
        this.categoryDAO = categoryDAO;
        this.messageSource = messageSource;
        this.userDAO = userDAO;
    }

    @ModelAttribute("newUser")
    public User user(){
        return new User();
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @RequestMapping(value = "/signup", method = {RequestMethod.GET, RequestMethod.POST})
    public String home(Model model){
        model.addAttribute("categories", this.categoryDAO.getCategories());
        model.addAttribute("newUser", new User());

        return "integrated:registration";
    }

    @RequestMapping(value ="signup/register", method = {RequestMethod.GET, RequestMethod.POST})
    public String getFormData(@Validated @ModelAttribute(value = "newUser") User newUser, final BindingResult errors, Model model){
        model.addAttribute("categories", this.categoryDAO.getCategories());
        if(errors.hasErrors()){
            return "integrated:registration";
        }
        userDAO.saveUser(newUser);
        return "redirect:/login";
    }
}
