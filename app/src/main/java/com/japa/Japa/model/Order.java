package com.japa.Japa.model;

import java.util.Date;

public class Order {

    private int orderId;
    private Date orderDate;
    private Date purchaseDate;
    private Integer userId;

    public Order(){}

    public Order(Date orderDate, Date purchaseDate, Integer userId){
        setOrderDate(orderDate);
        setPurchaseDate(purchaseDate);
        setUserId(userId);
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
