package com.japa.Japa.dataAccess.interfaceDAO;

import com.japa.Japa.dataAccess.entity.ProductEntity;
import com.japa.Japa.model.Product;

import java.util.List;

public interface IProductDAO {
    Product getProductById(int id);

    ProductEntity getProductEntityById(int id);

    List<Product> getAllProductsOfMainCategory(String mainCategory);

    List<Product> getProductsBySubCategory(String mainCategory, String Subcategory);
}
