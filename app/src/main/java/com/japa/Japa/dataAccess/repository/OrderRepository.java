package com.japa.Japa.dataAccess.repository;

import com.japa.Japa.dataAccess.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
}
