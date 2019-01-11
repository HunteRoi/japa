package com.japa.Japa.controller;

import com.japa.Japa.dataAccess.dao.CategoryDAO;
import com.japa.Japa.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
@SessionAttributes(value = "currentUser")
public class LoginController extends MainController {

    @Autowired
    public LoginController (CategoryDAO categoryDAO, MessageSource messageSource) { super(categoryDAO, messageSource); }

    @ModelAttribute("currentUser")
    public Login currentUser(){
        return new Login();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home (Model model, @ModelAttribute(value = "currentUser")Login currentUser){
        model.addAttribute("categories", this.categoryDAO.getCategories());
        return "integrated:login";
    }
}
