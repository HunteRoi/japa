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

    public double getWithoutDiscountTotal() {
        return products.values().stream().map(CommandLine::getPriceWithoutDiscount).reduce(0.0, (linePrice, total) -> total += linePrice);
    }

    public String getFormatedWithoutDiscountTotal() { return format.format(getWithoutDiscountTotal()); }

    public double getDiscountTotal() {
        return products.values().stream().map(CommandLine::getPriceWithDiscount).reduce(0.0, (linePrice, total) -> total += linePrice);
    }

    public String getFormatedWithDiscountTotal() { return format.format(getDiscountTotal()); }

    public double getFullTotal() { return getWithoutDiscountTotal() - getDiscountTotal(); }

    public String getFormatedFullTotal() { return format.format(getFullTotal()); }

    public double getTotalDiscount(){return getWithoutDiscountTotal() - getDiscountTotal();}

    public String getFormatedTotalDiscount(){return format.format(getTotalDiscount());}

    public HashMap<Integer, CommandLine> getCart(){
        return products;
    }
}
