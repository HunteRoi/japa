package com.japa.Japa.model;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;

public class Product {
    private double unitDiscount;
    private double productPrice;
    private String imageUrl;
    private HashMap<String, String> names;
    private HashMap<String, String> descriptions;
    private int id;
    private Category category;
    private DecimalFormat format;


    public Product() {
        format = new DecimalFormat("0.00", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        this.unitDiscount = 0.0;
        names = new HashMap<>();
        descriptions = new HashMap<>();
    }

    public boolean hasDiscount() {
        return unitDiscount > 0;
    }

    public String getFormatedRealPrice() { return format.format(productPrice - unitDiscount); }

    public double getUnitDiscount() {
        return unitDiscount;
    }

    public void setUnitDiscount(double unitDiscount) {
        this.unitDiscount = unitDiscount;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public String getFormatedProductPrice() {
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

    public String getShortDescription(String languageCode) { return getDescriptionByLanguage(languageCode).length() <= 150 ? getDescriptionByLanguage(languageCode) : getDescriptionByLanguage(languageCode).substring(0,150)+"..."; }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameByLanguage(String languageCode){
        return names.get(languageCode);
    }

    public String getDescriptionByLanguage(String languageCode){
        return descriptions.get(languageCode);
    }

    public HashMap<String, String> getNames() {
        return names;
    }

    public void setNames(HashMap<String, String> names) {
        this.names = names;
    }

    public HashMap<String, String> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(HashMap<String, String> descriptions) {
        this.descriptions = descriptions;
    }
}
