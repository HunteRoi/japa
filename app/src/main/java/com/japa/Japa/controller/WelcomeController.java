package com.japa.Japa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {
    @RequestMapping(value="/home", method = RequestMethod.GET)
    public String home (Model model) {
        return "integrated:welcome";
    }

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String homeRedirect (Model model) { return "redirect:/home"; }
}
