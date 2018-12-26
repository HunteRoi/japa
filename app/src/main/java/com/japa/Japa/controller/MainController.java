package com.japa.Japa.controller;

import com.japa.Japa.dataAccess.dao.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

public class MainController {
    protected CategoryDAO categoryDAO;
    protected final MessageSource messageSource;

    @Autowired
    public MainController (CategoryDAO categoryDAO, MessageSource messageSource) {
        this.categoryDAO = categoryDAO;
        this.messageSource = messageSource;
    }
}
