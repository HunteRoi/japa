package com.japa.Japa.model;

public class Product {
    private double productPrice;
    private String imageUrl;
    private String name;
    private String description;
    //private Category category;

    public Product(){}

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /*public Category getCategory() {
        return category;
    }*/

    /*public void setCategory(Category category) {
        this.category = category;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
