package com.japa.Japa.dataAccess.util;

import com.japa.Japa.dataAccess.entity.HierarchyEntity;
import com.japa.Japa.model.Category;

import java.util.ArrayList;
import java.util.List;

public class GetSubCategories {
    public static List<Category> getSubCategories(String mainCategory, List<Category> categories, List<HierarchyEntity> hierarchyEntities){
        ArrayList<Category> subCategories = new ArrayList<>();
        for(HierarchyEntity hierarchyEntity : hierarchyEntities){
            subCategories.add(getRightCategory(categories, hierarchyEntity.getSub_category().getName()));
            //getRightCategory(categories, hierarchyEntity.getMain_category().getName()).addSubCategory(getRightCategory(categories, hierarchyEntity.getSub_category().getName()));
        }
        return subCategories;
    }

    public static Category getRightCategory(List<Category> categories, String categoryName){
        return (categories.stream().filter(category -> category.getName().equals(categoryName)).findFirst().orElse(new Category()));
    }
}
