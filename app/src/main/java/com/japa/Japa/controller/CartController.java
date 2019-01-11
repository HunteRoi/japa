package com.japa.Japa.controller;

import com.japa.Japa.dataAccess.dao.CategoryDAO;
import com.japa.Japa.dataAccess.dao.ProductDAO;
import com.japa.Japa.model.Cart;
import com.japa.Japa.model.CommandLine;
import com.japa.Japa.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@Controller
@SessionAttributes({"shoppingCart"})
public class CartController extends MainController{

    private ProductDAO productDAO;

    @Autowired
    public CartController(CategoryDAO categoryDAO, MessageSource messageSource, ProductDAO productDAO) {
        super(categoryDAO, messageSource);
        this.productDAO = productDAO;
    }

    @RequestMapping(value = {"/cart/checkout"}, method = RequestMethod.GET)
    public String home (Model model, @ModelAttribute(value = "shoppingCart") Cart shoppingCart) {
        model.addAttribute("categories", this.categoryDAO.getCategories());
        model.addAttribute("products", shoppingCart.getCart().values());
        return "integrated:cart";
    }

    @RequestMapping(value = {"/cart/addProduct/{productID}"}, method = RequestMethod.POST)
    public String addProductToCart (@PathVariable String productID, @ModelAttribute(value = "shoppingCart") Cart shoppingCart, Locale locale) {
        shoppingCart.addProduct(this.productDAO.getProductById(Integer.parseInt(productID), locale.getLanguage()));
        return "redirect:/product/"+productID;
    }

    @RequestMapping(value = {"/cart/minus/{productID}"}, method = RequestMethod.POST)
    public String minusQuantityProduct (@PathVariable String productID, @ModelAttribute(value = "shoppingCart") Cart shoppingCart) {
        shoppingCart.getCart().get(Integer.parseInt(productID)).minusQuantity();
        return "redirect:/cart/checkout";
    }

    @RequestMapping(value = {"/cart/plus/{productID}"}, method = RequestMethod.POST)
    public String plusQuantityProduct (@PathVariable String productID, @ModelAttribute(value = "shoppingCart") Cart shoppingCart) {
        Cart cart = shoppingCart;
        shoppingCart.getCart().get(Integer.parseInt(productID)).plusQuantity();
        return "redirect:/cart/checkout";
    }
}
