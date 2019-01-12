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
import java.util.List;
import java.util.Locale;

@Controller
@SessionAttributes({"shoppingCart"})
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
    public String home (Model model, @ModelAttribute(value = "shoppingCart") Cart shoppingCart, Locale locale) {
        model.addAttribute("categories", this.categoryDAO.getCategories());
        Cart cart = promotionCalculation.getCartDiscount(shoppingCart, locale.getLanguage());
        model.addAttribute("products", shoppingCart.getCart().values());
        model.addAttribute("cart", shoppingCart);
        return "integrated:cart";
    }

    @RequestMapping(value = "/addProduct/{productID}", method = RequestMethod.POST)
    public String addProductToCart (@PathVariable String productID, @ModelAttribute(value = "shoppingCart") Cart shoppingCart, Locale locale) {
        shoppingCart.addProduct(this.productDAO.getProductById(Integer.parseInt(productID), locale.getLanguage()));
        return "redirect:/product/"+productID;
    }

    @RequestMapping(value = "/minus/{productID}", method = RequestMethod.POST)
    public String minusQuantityProduct (@PathVariable String productID, @ModelAttribute(value = "shoppingCart") Cart shoppingCart) {
        shoppingCart.removeProduct(Integer.parseInt(productID));
        return "redirect:/cart/checkout";
    }

    @RequestMapping(value = "/plus/{productID}", method = RequestMethod.POST)
    public String plusQuantityProduct (@PathVariable String productID, @ModelAttribute(value = "shoppingCart") Cart shoppingCart, Locale locale) {
        shoppingCart.addProduct(this.productDAO.getProductById(Integer.parseInt(productID), locale.getLanguage()));
        return "redirect:/cart/checkout";
    }

    @RequestMapping(value = "/validate")
    public String validate (Model model, @ModelAttribute(value="shoppingCart") Cart shoppingCart) {
        model.addAttribute("categories", this.categoryDAO.getCategories());
        model.addAttribute("cart", shoppingCart);
        Order order = new Order(new Date(), null, null);
        OrderEntity orderEntity = orderDAO.saveOrder(order);
        int ligne = 1;
        for(CommandLine commandLine : shoppingCart.getCart().values()){
            productLineDAO.saveProductLine(commandLine, ligne, orderEntity, productDAO.getProductEntityById(commandLine.getProduct().getId()));
            ligne++;
        }
        return "integrated:validation";
    }

    @RequestMapping(value="/bought", method = RequestMethod.GET)
    public String homeRedirectFromPaypal (@ModelAttribute(value = "shoppingCart") Cart shoppingCart) {
        shoppingCart.reset();
        return "redirect:/home";
    }
}
