package com.japa.Japa.model;

import java.util.Collection;

public class Category {

    private String name;
    private Collection<Category> underCategories;

    public Category(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Category> getUnderCategories() {
        return underCategories;
    }

    public void setUnderCategories(Collection<Category> underCategories) {
        this.underCategories = underCategories;
    }
}
