package com.japa.Japa.dataAccess.repository;

import com.japa.Japa.dataAccess.entity.PromotionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionRepository extends JpaRepository<PromotionEntity, Integer> {
}
