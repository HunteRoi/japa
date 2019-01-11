package com.japa.Japa.model;

import java.text.DecimalFormat;

public class CommandLine {

    private Product product;
    private int quantity;
    private double linePrice;
    private double discount;

    public CommandLine(Product product){
        setProduct(product);
        setQuantity(1);
        setLinePrice();
        setDiscount(0);
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

    public double getLinePrice() {
        return linePrice;
    }

    public String getFormatedLinePrice() { return new DecimalFormat("0.00").format(linePrice); }

    public void setLinePrice()
    {
        this.linePrice = product.getProductPrice() * quantity;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void plusQuantity(){
        quantity++;
        setLinePrice();
    }

    public void minusQuantity(){
        quantity--;
        setLinePrice();
    }
}
