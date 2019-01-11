package com.japa.Japa.controller;

import com.japa.Japa.dataAccess.dao.CategoryDAO;
import com.japa.Japa.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.ModelAttribute;

public class MainController {
    protected CategoryDAO categoryDAO;
    protected final MessageSource messageSource;

    @ModelAttribute(value = "shoppingCart")
    public Cart getCart(){
        return new Cart();
    }

    @Autowired
    public MainController (CategoryDAO categoryDAO, MessageSource messageSource) {
        this.categoryDAO = categoryDAO;
        this.messageSource = messageSource;
    }
}
