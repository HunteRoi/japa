package com.japa.Japa.controller;

import com.japa.Japa.business.PromotionCalculation;
import com.japa.Japa.dataAccess.dao.CategoryDAO;
import com.japa.Japa.dataAccess.dao.ProductDAO;
import com.japa.Japa.model.Cart;
import com.japa.Japa.model.Product;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping(value = "/category")
@SessionAttributes(Constants.CART)
public class ProductsController extends  MainController {

    private ProductDAO productDAO;
    private PromotionCalculation promotionCalculation;

    @Autowired
    public ProductsController(CategoryDAO categoryDAO, MessageSource messageSource, ProductDAO productDAO, PromotionCalculation promotionCalculation) {
        super(categoryDAO, messageSource);
        this.productDAO = productDAO;
        this.promotionCalculation = promotionCalculation;
    }

    @RequestMapping(value = "/{mainCategory}/{subCategory}", method = RequestMethod.GET)
    public String home (@PathVariable String mainCategory, @PathVariable String subCategory, Model model, @ModelAttribute(value = Constants.CART) Cart shoppingCart, Locale locale) {
        List<Product> products = productDAO.getProductsBySubCategory(mainCategory, subCategory.toString(), locale.getLanguage());
        return setAttributesAndReturnView(model, products, locale, shoppingCart);
    }

    @RequestMapping(value = "/{mainCategory}", method = RequestMethod.GET)
    public String home (@PathVariable String mainCategory, Model model, @ModelAttribute(value = Constants.CART) Cart shoppingCart, Locale locale) {
        List<Product> products = productDAO.getAllProductsOfMainCategory(mainCategory, locale.getLanguage());
        return setAttributesAndReturnView(model, products, locale, shoppingCart);
    }

    private String setAttributesAndReturnView(Model model, List<Product> products, Locale locale, Cart shoppingCart) {
        promotionCalculation.getProductsDiscounts(products, locale.getLanguage());
        model.addAttribute(Constants.CATEGORIES, this.categoryDAO.getCategories());
        model.addAttribute(Constants.PRODUCTS, products);
        model.addAttribute(Constants.CART, shoppingCart);
        return "integrated:products";
    }

}



