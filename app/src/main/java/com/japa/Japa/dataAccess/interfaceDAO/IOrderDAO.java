package com.japa.Japa.dataAccess.interfaceDAO;

import com.japa.Japa.dataAccess.entity.OrderEntity;
import com.japa.Japa.model.Order;

public interface IOrderDAO {
    public OrderEntity saveOrder(Order order);
}
