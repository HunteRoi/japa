package com.japa.Japa.controller;

import com.japa.Japa.dataAccess.dao.CategoryDAO;
import com.japa.Japa.dataAccess.dao.ProductDAO;
import com.japa.Japa.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Locale;

@Controller
public class ProductsController extends  MainController{

    private ProductDAO productDAO;

    @Autowired
    public ProductsController(CategoryDAO categoryDAO, MessageSource messageSource, ProductDAO productDAO) {
        super(categoryDAO, messageSource);
        this.productDAO = productDAO;
    }

    @RequestMapping(value = "/category/{mainCategory}/{subCategory}", method = RequestMethod.GET)
    public String home (@PathVariable String mainCategory, @PathVariable String subCategory, Model model, HttpServletRequest request, Locale locale) {
        List<Product> products;

        products = productDAO.getProductsBySubCategory(mainCategory, subCategory.toString(), locale.getLanguage());

        model.addAttribute("categories", this.categoryDAO.getCategories());
        model.addAttribute("products", products);
        return "integrated:products";
    }

    @RequestMapping(value = "/category/{mainCategory}", method = RequestMethod.GET)
    public String home (@PathVariable String mainCategory, Model model, HttpServletRequest request, Locale locale) {
        List<Product> products;

        products = productDAO.getAllProductsOfMainCategory(mainCategory, locale.getLanguage());

        model.addAttribute("categories", this.categoryDAO.getCategories());
        model.addAttribute("products", products);
        return "integrated:products";
    }

}



