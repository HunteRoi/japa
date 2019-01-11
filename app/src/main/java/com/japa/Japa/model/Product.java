package com.japa.Japa.model;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Product {
    private double productPrice;
    private String imageUrl;
    private String name;
    private String description;
    private int id;
    private Category category;

    public Product(){}

    public double getProductPrice() {
        return productPrice;
    }

    public String getFormatedProductPrice() {
        NumberFormat format = new DecimalFormat("#.00");
        return format.format(productPrice);
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public String getShortDescription() {
        return description.length() < 150 ? description : description.substring(0,150)+"...";
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
