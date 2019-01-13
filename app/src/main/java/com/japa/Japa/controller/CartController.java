package com.japa.Japa.controller;

import com.japa.Japa.business.PromotionCalculation;
import com.japa.Japa.dataAccess.dao.CategoryDAO;
import com.japa.Japa.dataAccess.dao.OrderDAO;
import com.japa.Japa.dataAccess.dao.ProductDAO;
import com.japa.Japa.dataAccess.dao.ProductLineDAO;
import com.japa.Japa.dataAccess.entity.OrderEntity;
import com.japa.Japa.model.Cart;
import com.japa.Japa.model.CommandLine;
import com.japa.Japa.model.Order;
import com.japa.Japa.model.Promo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Locale;

@Controller
@SessionAttributes(Constants.CART)
@RequestMapping("/cart")
public class CartController extends MainController{

    private ProductDAO productDAO;
    private ProductLineDAO productLineDAO;
    private PromotionCalculation promotionCalculation;
    private OrderDAO orderDAO;

    @Autowired
    public CartController(CategoryDAO categoryDAO, MessageSource messageSource, ProductDAO productDAO, PromotionCalculation promotionCalculation, OrderDAO orderDAO, ProductLineDAO productLineDAO) {
        super(categoryDAO, messageSource);
        this.productDAO = productDAO;
        this.productLineDAO = productLineDAO;
        this.promotionCalculation = promotionCalculation;
        this.orderDAO = orderDAO;
    }

    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    public String home (Model model, @ModelAttribute(value = Constants.CART) Cart shoppingCart, Locale locale) {
        promotionCalculation.getCartDiscount(shoppingCart, locale.getLanguage());
        model.addAttribute(Constants.CATEGORIES, this.categoryDAO.getCategories());
        model.addAttribute(Constants.PRODUCTS, shoppingCart.getCart().values());
        model.addAttribute(Constants.CART, shoppingCart);
        return "integrated:cart";
    }

    @RequestMapping(value = "/addProduct/{productID}", method = RequestMethod.POST)
    public String addProductToCart (@PathVariable String productID, @ModelAttribute(value = Constants.CART) Cart shoppingCart, Locale locale) {
        shoppingCart.addProduct(this.productDAO.getProductById(Integer.parseInt(productID), locale.getLanguage()));
        return "redirect:/product/"+productID;
    }

    @RequestMapping(value = "/minus/{productID}", method = RequestMethod.POST)
    public String minusQuantityProduct (@PathVariable String productID, @ModelAttribute(value = Constants.CART) Cart shoppingCart) {
        shoppingCart.removeProduct(Integer.parseInt(productID));
        return "redirect:/cart/checkout";
    }

    @RequestMapping(value = "/plus/{productID}", method = RequestMethod.POST)
    public String plusQuantityProduct (@PathVariable String productID, @ModelAttribute(value = Constants.CART) Cart shoppingCart, Locale locale) {
        shoppingCart.addProduct(this.productDAO.getProductById(Integer.parseInt(productID), locale.getLanguage()));
        return "redirect:/cart/checkout";
    }

    @RequestMapping(value = "/validate")
    public String validate (Model model, @ModelAttribute(value = Constants.CART) Cart shoppingCart) {
        model.addAttribute(Constants.CATEGORIES, this.categoryDAO.getCategories());
        model.addAttribute(Constants.CART, shoppingCart);
        Order order = new Order(new Date(), new Date(), null);
        OrderEntity orderEntity = orderDAO.saveOrder(order);

        for (int i = 0; i < shoppingCart.getCart().values().size(); i++) {
            CommandLine cl = (CommandLine) shoppingCart.getCart().values().toArray()[i];
            productLineDAO.saveProductLine(cl, i+1, orderEntity, productDAO.getProductEntityById(cl.getProduct().getId()));
        }

        return "integrated:validation";
    }

    @RequestMapping(value="/bought", method = RequestMethod.GET)
    public String homeRedirectFromPaypal (@ModelAttribute(value = Constants.CART) Cart shoppingCart) {
        shoppingCart.reset();
        return "redirect:/home";
    }
}
