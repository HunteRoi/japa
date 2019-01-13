package com.japa.Japa.controller;

import com.japa.Japa.business.PromotionCalculation;
import com.japa.Japa.dataAccess.dao.CategoryDAO;
import com.japa.Japa.dataAccess.dao.ProductDAO;
import com.japa.Japa.model.Cart;
import com.japa.Japa.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@Controller
@SessionAttributes(Constants.CART)
public class ProductController  extends MainController{

    private ProductDAO productDAO;
    private PromotionCalculation promotionCalculation;

    @Autowired
    public ProductController(CategoryDAO categoryDAO, MessageSource messageSource, ProductDAO productDAO, PromotionCalculation promotionCalculation) {
        super(categoryDAO, messageSource);
        this.productDAO = productDAO;
        this.promotionCalculation = promotionCalculation;
    }

    @RequestMapping(value = {"/product/{productID}"},method = RequestMethod.GET)
    public String home (@PathVariable String productID, Model model, Locale locale, @ModelAttribute(value = Constants.CART) Cart shoppingCart) {
        Product product =  this.productDAO.getProductById(Integer.parseInt(productID), locale.getLanguage());
        promotionCalculation.getProductDiscount(product, locale.getLanguage());
        model.addAttribute(Constants.CATEGORIES, this.categoryDAO.getCategories());
        model.addAttribute(Constants.CART, shoppingCart);
        model.addAttribute(Constants.PRODUCT, product);
        return "integrated:product";
    }
}
