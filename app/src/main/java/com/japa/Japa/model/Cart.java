package com.japa.Japa.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Cart {
    private HashMap<Integer, CommandLine> products;

    public Cart(){
        products = new HashMap<>();
    }

    public void addProduct(Product product){
        if(products.containsKey(product.getId())){
            //products.get(product.getId()).
        }else{
            products.put(product.getId(), new CommandLine(product));
        }
    }

    public HashMap<Integer, CommandLine> getCart(){
        Collection<CommandLine> test = products.values();
        return products;
    }
}
