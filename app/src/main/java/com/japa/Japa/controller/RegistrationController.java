package com.japa.Japa.controller;

import com.japa.Japa.business.CategoryBusiness;
import com.japa.Japa.business.UserBusiness;
import com.japa.Japa.dataAccess.dao.CategoryDAO;
import com.japa.Japa.dataAccess.dao.UserDAO;
import com.japa.Japa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    private UserBusiness userBusiness;
    private CategoryBusiness categoryBusiness;

    @Autowired
    public RegistrationController (CategoryDAO categoryDAO, /*MessageSource messageSource,*/ UserDAO userDAO) {
        //super(categoryDAO, messageSource);
        userBusiness = new UserBusiness(userDAO);
        categoryBusiness = new CategoryBusiness(categoryDAO);
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
        model.addAttribute(Constants.CATEGORIES, categoryBusiness.getCategories());
        model.addAttribute(Constants.NEW_USER, new User());
        //model.addAttribute(Constants.CART, shoppingCart);
        return "integrated:registration";
    }

    @RequestMapping(value ="/register", method = {RequestMethod.GET, RequestMethod.POST})
    public String getFormData(/*@ModelAttribute(Constants.CART) Cart shoppingCart,*/ Model model,
                              @Validated @ModelAttribute(value = Constants.NEW_USER) User newUser, final BindingResult errors)
    {
        //model.addAttribute(Constants.CART, shoppingCart);
        model.addAttribute(Constants.CATEGORIES, categoryBusiness.getCategories());
        if(errors.hasErrors()) {
            return "integrated:registration";
        }
        userBusiness.saveUser(newUser);
        return "redirect:/signin";
    }
}
