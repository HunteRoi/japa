package com.japa.Japa.model;

import java.text.DecimalFormat;

public class CommandLine {

    private Product product;
    private int quantity;
    private double unitDiscount;
    private DecimalFormat decimalFormat;

    public CommandLine(Product product){
        setProduct(product);
        setQuantity(1);
        setUnitDiscount(0);
        decimalFormat = new DecimalFormat("0.00");
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getFormatedPriceWithoutDiscount() { return decimalFormat.format(getPriceWithoutDiscount()); }

    public String getFormatedPriceWithDiscount() { return decimalFormat.format(getPriceWithDiscount()); }

    public String getFormatedUnitPrice() {return decimalFormat.format(product.getProductPrice());}

    public String getFormatedUnitDiscountPrice(){return decimalFormat.format(getUnitDiscount());}

    public double getUnitDiscount() {
        return unitDiscount;
    }

    public void setUnitDiscount(double discount) {
        this.unitDiscount = discount;
    }

    public double getPriceWithoutDiscount(){
        return product.getProductPrice() * quantity;
    }

    public double getPriceWithDiscount(){
        return getPriceWithoutDiscount() - (unitDiscount * quantity);
    }

    public void plusQuantity(){
        quantity++;
    }

    public void minusQuantity(){
        quantity--;
    }
}
