package com.japa.Japa.dataAccess.repository;

import com.japa.Japa.dataAccess.entity.ProductTranslationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTranslationRepository extends JpaRepository<ProductTranslationEntity, Integer> {
}
