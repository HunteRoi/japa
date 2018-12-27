package com.japa.Japa.controller;

import com.japa.Japa.dataAccess.dao.CategoryDAO;
import com.japa.Japa.dataAccess.dao.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
public class ProductController  extends MainController{

    private ProductDAO productDAO;

    @Autowired
    public ProductController(CategoryDAO categoryDAO, MessageSource messageSource, ProductDAO productDAO) {
        super(categoryDAO, messageSource);
        this.productDAO = productDAO;
    }

    @RequestMapping(value = {"/product/{productID}"},method = RequestMethod.GET)
    public String home (@PathVariable String productID, Model model, Locale locale) {
        model.addAttribute("categories", this.categoryDAO.getCategories());
        model.addAttribute("product", this.productDAO.getProductById(Integer.parseInt(productID), locale.getLanguage()));
        return "integrated:product";
    }
}
