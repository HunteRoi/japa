package com.japa.Japa.dataAccess.util;

import com.japa.Japa.dataAccess.entity.CategoryEntity;
import com.japa.Japa.model.Category;
import org.springframework.stereotype.Component;

@Component
public class ProviderConverter {

    public Category categoryEntityToCategoryModel(CategoryEntity categoryEntity){
        Category category = new Category();
        category.setName(categoryEntity.getName());
        return category;
    }

}
