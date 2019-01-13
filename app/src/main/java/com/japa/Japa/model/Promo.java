package com.japa.Japa.model;

import java.util.Date;

public class Promo {
    private Product product;
    private Promotion promotion;

    public Promo(){}

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public boolean isApplicable() {
        Date now = new Date();
        Date start = getPromotion().getStartDate();
        Date end = getPromotion().getEndDate();

        return (now.after(start) || now.equals(start)) && now.before(end);
    }

}
