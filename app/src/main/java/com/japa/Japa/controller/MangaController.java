package com.japa.Japa.controller;

import com.japa.Japa.dataAccess.dao.CategoryDAO;
import com.japa.Japa.dataAccess.dao.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MangaController extends MainController {

    private ProductDAO productDAO;

    @Autowired
    public MangaController (CategoryDAO categoryDAO, ProductDAO productDAO) {
        super(categoryDAO);
        this.productDAO = productDAO;
    }

    @RequestMapping(value = {"/Mangas","/Mangas/Shonen","/Mangas/Shojo"},method = RequestMethod.GET)
    public String home (Model model, HttpServletRequest request) {
       /*String uri = request.getRequestURI();
        String requests[] = uri.split("/");
        if(requests[1] == null) System.out.println();*/
        productDAO.test();
        model.addAttribute("categories", this.categoryDAO.getCategories());
        return "integrated:product";
    }

}
