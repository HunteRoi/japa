package com.japa.Japa.model;

import java.util.ArrayList;
import java.util.Collection;

public class Category {

    private Integer id;
    private String name;
    private Boolean hasNoChildren;
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

    public String getNormalizedName() { return name.toLowerCase(); }

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

    public Boolean getHasNoChildren() {
        return hasNoChildren;
    }

    public void setHasNoChildren(Boolean hasNoChildren) {
        this.hasNoChildren = hasNoChildren;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
