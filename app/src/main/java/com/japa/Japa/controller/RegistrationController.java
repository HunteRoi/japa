package com.japa.Japa.controller;

import com.japa.Japa.dataAccess.dao.CategoryDAO;
import com.japa.Japa.dataAccess.dao.UserDAO;
import com.japa.Japa.model.Cart;
import com.japa.Japa.model.Category;
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
@RequestMapping(value="/signup")
@SessionAttributes({/*Constants.CART,*/ Constants.NEW_USER})
public class RegistrationController /*extends MainController*/{

    @Autowired
    @Qualifier("userValidator")
    private Validator validator;
    private CategoryDAO categoryDAO;
    private UserDAO userDAO;

    @Autowired
    public RegistrationController (CategoryDAO categoryDAO, /*MessageSource messageSource,*/ UserDAO userDAO) {
        //super(categoryDAO, messageSource);
        this.categoryDAO = categoryDAO;
        this.userDAO = userDAO;
    }

    @ModelAttribute(Constants.NEW_USER)
    public User user(){
        return new User();
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String home(Model model/*, @ModelAttribute(Constants.CART) Cart shoppingCart*/) {
        model.addAttribute(Constants.CATEGORIES, this.categoryDAO.getCategories());
        model.addAttribute(Constants.NEW_USER, new User());
        //model.addAttribute(Constants.CART, shoppingCart);
        return "integrated:registration";
    }

    @RequestMapping(value ="/register", method = {RequestMethod.GET, RequestMethod.POST})
    public String getFormData(/*@ModelAttribute(Constants.CART) Cart shoppingCart,*/ Model model,
                              @Validated @ModelAttribute(value = Constants.NEW_USER) User newUser, final BindingResult errors)
    {
        //model.addAttribute(Constants.CART, shoppingCart);
        model.addAttribute(Constants.CATEGORIES, this.categoryDAO.getCategories());
        if(errors.hasErrors()) {
            return "integrated:registration";
        }
        userDAO.saveUser(newUser);
        return "redirect:/signin";
    }
}
