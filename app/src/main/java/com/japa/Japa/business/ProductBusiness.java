package com.japa.Japa.business;

import com.japa.Japa.dataAccess.dao.ProductDAO;
import com.japa.Japa.dataAccess.entity.ProductEntity;
import com.japa.Japa.model.Product;

import java.util.List;


public class ProductBusiness {
    private ProductDAO productDAO;

    public ProductBusiness(ProductDAO productDAO){
        this.productDAO = productDAO;
    }

    public Product getProductById(int id){
        return productDAO.getProductById(id);
    }

    public ProductEntity getProductEntityById(int id){
        return productDAO.getProductEntityById(id);
    }

    public List<Product> getAllProductsOfMainCategory(String mainCategory){
        return productDAO.getAllProductsOfMainCategory(mainCategory);
    }

    public List<Product> getProductsBySubCategory(String mainCategory, String Subcategory){
        return productDAO.getProductsBySubCategory(mainCategory, Subcategory);
    }

    //public void changeProductLanguage()

}
