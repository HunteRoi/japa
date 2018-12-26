package com.japa.Japa.controller;

import com.japa.Japa.dataAccess.dao.CategoryDAO;
import com.japa.Japa.dataAccess.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController extends MainController {

    @Autowired
    public LoginController (CategoryDAO categoryDAO) { super(categoryDAO); }

    @RequestMapping(method = RequestMethod.GET)
<<<<<<< Updated upstream
    public String home (Model model, @ModelAttribute UserEntity user){
        model.addAttribute("categories", this.categoryDAO.getCategories());
        model.addAttribute("current_user", user);
        return "integrated:login";
    }
=======
    public String home (Model model, @ModelAttribute UserEntity user) {
        model.addAttribute("current_user", new UserEntity());
        return "integrated:login";
    }

>>>>>>> Stashed changes
}
