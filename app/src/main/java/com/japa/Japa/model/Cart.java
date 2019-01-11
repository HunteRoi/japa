package com.japa.Japa.model;


import java.util.Collection;
import java.util.HashMap;

public class Cart {
    private HashMap<Integer, CommandLine> products;

    public Cart(){
        products = new HashMap<>();
    }

    public void addProduct(Product product){
        if(products.containsKey(product.getId())){
            products.get(product.getId()).plusQuantity();
        }else{
            products.put(product.getId(), new CommandLine(product));
        }
    }

    public HashMap<Integer, CommandLine> getCart(){
        return products;
    }
}
