package com.japa.Japa.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "ProductLine")
public class ProductLineEntity {
    @Id
    @Column
    private int product_line_id;
    @Column
    private int quantity;
    @Column
    private double order_produc_price;
    @Column
    private int line_number;
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    @ManyToOne
    private OrderEntity order;
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    @ManyToOne
    private ProductEntity product;

    public ProductLineEntity(){}

    public int getProduct_line_id() {
        return product_line_id;
    }

    public void setProduct_line_id(int product_line_id) {
        this.product_line_id = product_line_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getOrder_produc_price() {
        return order_produc_price;
    }

    public void setOrder_produc_price(double order_produc_price) {
        this.order_produc_price = order_produc_price;
    }

    public int getLine_number() {
        return line_number;
    }

    public void setLine_number(int line_number) {
        this.line_number = line_number;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }
}
