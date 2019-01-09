package com.japa.Japa.controller;

import com.japa.Japa.dataAccess.dao.CategoryDAO;
import com.japa.Japa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.*;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@SessionAttributes ("newUser")
public class RegistrationController extends MainController{

    @Autowired
    public RegistrationController (CategoryDAO categoryDAO, MessageSource messageSource)
    { super(categoryDAO, messageSource); }

    @ModelAttribute("newUser")
    public User user(){
        return new User();
    }

    @RequestMapping(value = "/signup", method = {RequestMethod.GET, RequestMethod.POST})
    public String home(Model model){
        model.addAttribute("categories", this.categoryDAO.getCategories());
        model.addAttribute("newUser", new User());
        return "integrated:registration";
    }

    /*@InitBinder
    public void initBinder(WebDataBinder binder) {
        // tell spring to set empty values as null instead of empty string.
        binder.registerCustomEditor( String.class, new StringTrimmerEditor( true ));
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setLenient(false);
        binder.registerCustomEditor( Date.class, new CustomDateEditor( simpleDateFormat,false));
    }*/

    @RequestMapping(value ="signup/register", method = {RequestMethod.GET, RequestMethod.POST})
    public String getFormData(@Valid @ModelAttribute(value = "newUser") User newUser, final BindingResult errors){
        if(errors.hasErrors()){
            errors.getFieldErrors().stream().forEach(f->System.out.println(f.getField() + " - " + f.getDefaultMessage()));
            return "redirect:/signup";
        }
        //System.out.println(newUser.getBirthdate().toString());
        return "";
    }


}