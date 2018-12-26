/*package com.japa.Japa.controller;

import com.japa.Japa.dataAccess.dao.CategoryDAO;
import com.japa.Japa.dataAccess.dao.ProductDAO;
import com.japa.Japa.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class MangaController extends MainController {

    private ProductDAO productDAO;

    @Autowired
    public MangaController (CategoryDAO categoryDAO, MessageSource messageSource, ProductDAO productDAO) {
        super(categoryDAO, messageSource);
        this.productDAO = productDAO;
    }

    @RequestMapping(value = {"/mangas","/mangas/shonen","/mangas/shojo"},method = RequestMethod.GET)
    public String home (Model model, HttpServletRequest request, Locale locale) {
        List<Product> products = new ArrayList<>();
        String uri = request.getRequestURI();
        String requests[] = uri.split("/");

        if(requests.length == 4) products = productDAO.getProductsBySubCategory("Mangas",requests[requests.length-1], locale.getLanguage());

        model.addAttribute("categories", this.categoryDAO.getCategories());
        model.addAttribute("products", products);
        return "integrated:products";
    }

}*/
