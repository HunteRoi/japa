package com.japa.Japa.controller;

import com.japa.Japa.business.CategoryBusiness;
import com.japa.Japa.dataAccess.dao.CategoryDAO;
import com.japa.Japa.model.Cart;
import com.japa.Japa.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes(Constants.CART)
public class MainController {
    protected CategoryDAO categoryDAO;
    protected CategoryBusiness categoryBusiness;
    protected final MessageSource messageSource;

    @ModelAttribute(value = Constants.CART)
    public Cart getCart(){
        return new Cart();
    }

    @Autowired
    public MainController (CategoryDAO categoryDAO, MessageSource messageSource) {
        this.categoryDAO = categoryDAO;
        this.messageSource = messageSource;
        categoryBusiness = new CategoryBusiness(categoryDAO);
    }
}
