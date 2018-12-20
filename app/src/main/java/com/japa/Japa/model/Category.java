package com.japa.Japa.model;

import java.util.ArrayList;
import java.util.Collection;

public class Category {

    private String name;
    private ArrayList<Category> subCategories;

    public Category(){
        subCategories = new ArrayList<>();
    }

    public Category(String name){
        setName(name);
        subCategories = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Category> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(ArrayList<Category> subCategories) {
        this.subCategories = subCategories;
    }

    public void addSubCategory(Category category){this.subCategories.add(category);}

}
