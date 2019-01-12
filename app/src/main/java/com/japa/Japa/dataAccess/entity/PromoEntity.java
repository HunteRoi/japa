package com.japa.Japa.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "Promo")
public class PromoEntity {
    @Id
    @Column
    private Integer promo_id;
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    @ManyToOne
    private ProductEntity product;
    @JoinColumn(name = "promotion_id", referencedColumnName = "promotion_id")
    @ManyToOne
    private PromotionEntity promotion;

    public PromoEntity(){}

    public Integer getPromo_id() {
        return promo_id;
    }

    public void setPromo_id(Integer promo_id) {
        this.promo_id = promo_id;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public PromotionEntity getPromotion() {
        return promotion;
    }

    public void setPromotion(PromotionEntity promotion) {
        this.promotion = promotion;
    }
}
