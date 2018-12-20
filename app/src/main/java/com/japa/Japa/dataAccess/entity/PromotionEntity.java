package com.japa.Japa.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "Promotion")
public class PromotionEntity {
    @Id
    @Column
    private int promotion_id;
    @Column
    private String label;
    @Column
    private double pourcent;
    @Column
    private Date start_date;
    @Column
    private Date end_date;

    public PromotionEntity(){}

    public int getPromotion_id() {
        return promotion_id;
    }

    public void setPromotion_id(int promotion_id) {
        this.promotion_id = promotion_id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getPourcent() {
        return pourcent;
    }

    public void setPourcent(double pourcent) {
        this.pourcent = pourcent;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }
}
