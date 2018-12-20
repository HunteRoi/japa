package com.japa.Japa.dataAccess.repository;

import com.japa.Japa.dataAccess.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer>{
}
