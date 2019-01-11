package com.japa.Japa.model;

import java.util.Date;

public class Promotion {
    private int promotion_id;
    private double pourcent;
    private Date startDate;
    private Date endDate;

    public Promotion(){

    }

    public int getPromotion_id() {
        return promotion_id;
    }

    public void setPromotion_id(int promotion_id) {
        this.promotion_id = promotion_id;
    }

    public double getPourcent() {
        return pourcent;
    }

    public void setPourcent(double pourcent) {
        this.pourcent = pourcent;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
