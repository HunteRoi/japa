package com.japa.Japa.controller;

import com.japa.Japa.dataAccess.dao.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController extends MainController {

    @Autowired
    public WelcomeController (CategoryDAO categoryDAO) { super(categoryDAO); }

    @RequestMapping(value="/home", method = RequestMethod.GET)
    public String home (Model model) {
        model.addAttribute("categories", this.categoryDAO.getCategories());
        return "integrated:welcome";
    }

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String homeRedirect (Model model) { return "redirect:/home"; }
}
