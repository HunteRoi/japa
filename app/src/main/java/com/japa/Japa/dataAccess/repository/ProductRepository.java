package com.japa.Japa.dataAccess.repository;

import com.japa.Japa.dataAccess.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
}
