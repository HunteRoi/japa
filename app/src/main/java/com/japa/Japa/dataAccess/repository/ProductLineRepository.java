package com.japa.Japa.dataAccess.repository;

import com.japa.Japa.dataAccess.entity.ProductLineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductLineRepository extends JpaRepository<ProductLineEntity, Integer> {
}
