package com.japa.Japa.dataAccess.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Product")
public class ProductEntity {
    @Id
    @Column
    private int product_id;
    @Column
    private double product_price;
    @Column
    private String image_url;
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    @ManyToOne
    private CategoryEntity category;
    @OneToMany(mappedBy = "product")
    private Collection<ProductTranslationEntity> translationEntities;

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

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Collection<ProductTranslationEntity> getTranslationEntities() {
        return translationEntities;
    }

    public void setTranslationEntities(Collection<ProductTranslationEntity> translationEntities) {
        this.translationEntities = translationEntities;
    }
}
