package com.japa.Japa.controller;

import com.japa.Japa.dataAccess.dao.UserDAO;
import com.japa.Japa.dataAccess.entity.UserEntity;
import com.japa.Japa.dataAccess.util.Encryption;
import com.japa.Japa.exception.LoginDataException;
import com.japa.Japa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/login")
@SessionAttributes("current_user")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public String home (Model model/*, @ModelAttribute UserDetails user*/) {
        model.addAttribute("current_user", new UserEntity());
        return "integrated:login";
    }

    @ModelAttribute("current_user")
    public User login(){
        return new User();
    }

}
