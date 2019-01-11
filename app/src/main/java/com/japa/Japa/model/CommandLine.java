package com.japa.Japa.model;

public class CommandLine {

    private Product product;
    private int quantity;
    private double linePrice;

    public CommandLine(Product product){
        setProduct(product);
        setQuantity(1);
        setLinePrice();
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

    public void setLinePrice()
    {
        this.linePrice = product.getProductPrice() * quantity;
    }

    public void plusQuantity(){
        quantity++;
        setLinePrice();
    }

    public void minusQuantity(){
        if(quantity > 1) quantity--;
        setLinePrice();
    }
}
