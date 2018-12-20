package com.japa.Japa.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "ProductTranslation")
public class ProductTranslationEntity {
    @Id
    @Column
    private int product_translation_id;
    @Column
    private String name;
    @Column
    private String description;
    @JoinColumn (name = "product_id", referencedColumnName = "product_id")
    @ManyToOne
    private ProductEntity product;
    @JoinColumn (name = "language_id", referencedColumnName = "language_id")
    @ManyToOne
    private LanguageEntity language;

    public ProductTranslationEntity(){}

    public int getProduct_translation_id() {
        return product_translation_id;
    }

    public void setProduct_translation_id(int product_translation_id) {
        this.product_translation_id = product_translation_id;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public LanguageEntity getLanguage() {
        return language;
    }

    public void setLanguage(LanguageEntity language) {
        this.language = language;
    }
}
