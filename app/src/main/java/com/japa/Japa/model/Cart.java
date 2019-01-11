package com.japa.Japa.model;


import java.text.DecimalFormat;
import java.util.HashMap;

public class Cart {
    private HashMap<Integer, CommandLine> products;
    private DecimalFormat format;

    public Cart(){
        products = new HashMap<>();
        format = new DecimalFormat("0.00");
    }

    public void addProduct(Product product){
        if (products.containsKey(product.getId())){
            products.get(product.getId()).plusQuantity();
        } else {
            products.put(product.getId(), new CommandLine(product));
        }
    }

    public void removeProduct (int productId) {
        if (products.containsKey(productId)) {
            products.get(productId).minusQuantity();
            if (products.get(productId).getQuantity() <= 0) {
                products.remove(productId);
            }
        }
    }

    public double getTotal() {
        return products.values().stream().map(CommandLine::getLinePrice).reduce(0.0, (linePrice, total) -> total += linePrice);
    }

    public String getFormatedTotal() { return format.format(getTotal()); }

    public double getDiscountTotal() { return 0.00; }

    public String getFormatedDiscountTotal() { return format.format(getDiscountTotal()); }

    public double getFullTotal() { return getTotal() - getDiscountTotal(); }

    public String getFormatedFullTotal() { return format.format(getFullTotal()); }



    public HashMap<Integer, CommandLine> getCart(){
        return products;
    }
}
