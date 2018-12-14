package com.japa.Japa.dataAccess.entity;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table (name = "Category")
public class CategoryEntity {
    @Id
    @Column
    private int category_id;
    @Column
    private String name;
    @OneToMany(mappedBy = "category")
    private ArrayList<CategoryEntity> underCategories;

    public CategoryEntity(){}

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<CategoryEntity> getUnderCategories() {
        return underCategories;
    }

    public void setUnderCategories(ArrayList<CategoryEntity> underCategories) {
        this.underCategories = underCategories;
    }
}
