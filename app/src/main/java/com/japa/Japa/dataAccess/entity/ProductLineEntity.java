package com.japa.Japa.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "Product_line")
public class ProductLineEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer product_line_id;
    @Column
    private Integer quantity;
    @Column
    private Double order_product_price;
    @Column
    private Integer line_number;
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    @ManyToOne
    private OrderEntity order;
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    @ManyToOne
    private ProductEntity product;

    public ProductLineEntity(){}

    public Integer getProduct_line_id() {
        return product_line_id;
    }

    public void setProduct_line_id(Integer product_line_id) {
        this.product_line_id = product_line_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getOrder_product_price() {
        return order_product_price;
    }

    public void setOrder_product_price(Double order_product_price) {
        this.order_product_price = order_product_price;
    }

    public Integer getLine_number() {
        return line_number;
    }

    public void setLine_number(Integer line_number) {
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
