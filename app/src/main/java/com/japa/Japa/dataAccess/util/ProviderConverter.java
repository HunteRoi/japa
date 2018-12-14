package com.japa.Japa.dataAccess.util;

import com.japa.Japa.dataAccess.entity.CategoryEntity;
import com.japa.Japa.model.Category;

import java.util.ArrayList;


public class ProviderConverter {
    public Category categoryModelToCategoryEntity(CategoryEntity categoryEntity){
        Category category = new Category();
        ArrayList<Category> undercategories = new ArrayList<>();
        category.setName(categoryEntity.getName());
        for(CategoryEntity categoryEntity1 : categoryEntity.getUnderCategories()){
            Category underCategory = new Category();
            category.setName(categoryEntity1.getName());
            undercategories.add(underCategory);
        }
        category.setUnderCategories(undercategories);
        return category;
    }
}
