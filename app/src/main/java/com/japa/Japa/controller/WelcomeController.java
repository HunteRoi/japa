package com.japa.Japa.controller;

import com.japa.Japa.dataAccess.dao.CategoryDAO;
import com.japa.Japa.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(Constants.CART)
public class WelcomeController extends MainController {

    @Autowired
    public WelcomeController (CategoryDAO categoryDAO, MessageSource messageSource) { super(categoryDAO, messageSource); }

    @RequestMapping(value="/home", method = RequestMethod.GET)
    public String home (Model model, @ModelAttribute(value = Constants.CART) Cart shoppingCart) {
        model.addAttribute(Constants.CART, shoppingCart);
        model.addAttribute(Constants.CATEGORIES, this.categoryDAO.getCategories());
        return "integrated:welcome";
    }

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String homeRedirect (Model model) { return "redirect:/home"; }


}
