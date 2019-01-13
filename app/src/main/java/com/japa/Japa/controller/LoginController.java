package com.japa.Japa.controller;

import com.japa.Japa.dataAccess.dao.CategoryDAO;
import com.japa.Japa.model.Cart;
import com.japa.Japa.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/signin")
@SessionAttributes({Constants.CURRENT_USER, Constants.CART})
public class LoginController extends MainController {

    @Autowired
    public LoginController (CategoryDAO categoryDAO, MessageSource messageSource) { super(categoryDAO, messageSource); }

    @ModelAttribute(Constants.CURRENT_USER)
    public Login currentUser() {
        return new Login();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home (Model model, @ModelAttribute(value = Constants.CURRENT_USER)Login currentUser, @ModelAttribute(value = Constants.CART) Cart shoppingCart){
        model.addAttribute(Constants.CATEGORIES, categoryBusiness.getCategories());
        model.addAttribute(Constants.CART, shoppingCart);
        return "integrated:login";
    }
}
