package com.japa.Japa.dataAccess.dao;

import com.japa.Japa.dataAccess.entity.OrderEntity;
import com.japa.Japa.dataAccess.repository.OrderRepository;
import com.japa.Japa.dataAccess.util.ProviderConverter;
import com.japa.Japa.model.Order;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class OrderDAO {
    private OrderRepository orderRepository;
    private ProviderConverter providerConverter;

    public OrderDAO(OrderRepository orderRepository, ProviderConverter providerConverter){
        this.orderRepository = orderRepository;
        this.providerConverter = providerConverter;
    }

    public OrderEntity saveOrder(Order order){
        OrderEntity orderEntity = providerConverter.orderModelToOrderEntity(order);
        orderRepository.save(orderEntity);
        return  orderEntity;
    }
}
