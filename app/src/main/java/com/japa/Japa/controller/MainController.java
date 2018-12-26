package com.japa.Japa.controller;

import com.japa.Japa.dataAccess.dao.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;

public class MainController {
    protected CategoryDAO categoryDAO;

    @Autowired
    public MainController (CategoryDAO categoryDAO) { this.categoryDAO = categoryDAO; }
}
