package com.japa.Japa.business;

import com.japa.Japa.dataAccess.dao.OrderDAO;
import com.japa.Japa.dataAccess.entity.OrderEntity;
import com.japa.Japa.model.Order;


public class OrderBusiness {
    private OrderDAO orderDAO;

    public OrderBusiness(OrderDAO orderDAO){
        this.orderDAO = orderDAO;
    }

    public OrderEntity saveOrder(Order order){
        return orderDAO.saveOrder(order);
    }
}
