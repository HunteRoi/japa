package com.japa.Japa.business;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CalculateDiscountTest {
    private double totalPrice;
    private double discount;
    private PromotionCalculation promotionCalculation;


    @Before
    @Autowired
    public void setup(PromotionCalculation promotionCalculation)throws Exception{
        totalPrice = 10.0;
        discount = 20.0;
        this.promotionCalculation = promotionCalculation;
    }

    @Test
    public void calculateDiscount(){
        // Double is deprecated
        Assert.assertEquals((long)2.0, ((long)promotionCalculation.calculateDiscount(totalPrice, discount)));
    }

}
