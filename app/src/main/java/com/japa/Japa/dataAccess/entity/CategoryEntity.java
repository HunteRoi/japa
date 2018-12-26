package com.japa.Japa.dataAccess.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table (name = "Category")
public class CategoryEntity {
    @Id
    @Column
    private int category_id;
    @Column
    private String name;
    @Column
    private Boolean has_no_children;

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

    public Boolean getHas_no_children() {
        return has_no_children;
    }

    public void setHas_no_children(Boolean has_no_children) {
        this.has_no_children = has_no_children;
    }
}
