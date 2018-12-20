package com.japa.Japa.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "Product")
public class ProductEntity {
    @Id
    @Column
    private int product_id;
    @Column
    private double product_price;
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    @ManyToOne
    private CategoryEntity category;

    public ProductEntity(){}

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
}
