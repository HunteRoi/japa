package com.japa.Japa.dataAccess.entity;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "User_order")
public class OrderEntity {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer order_id;

    @Column(name = "order_date")
    private Date order_date;

    @Column(name = "purchase_date")
    @Nullable
    private Date purchase_date;

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private UserEntity user_id;

    public OrderEntity(){}

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public Date getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(Date purchase_date) {
        this.purchase_date = purchase_date;
    }

    public UserEntity getUser_id() {
        return user_id;
    }

    public void setUser_id(UserEntity user_id) {
        this.user_id = user_id;
    }
}
