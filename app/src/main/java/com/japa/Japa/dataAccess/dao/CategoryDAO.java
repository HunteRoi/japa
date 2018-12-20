package com.japa.Japa.dataAccess.dao;

import com.japa.Japa.dataAccess.entity.CategoryEntity;
import com.japa.Japa.dataAccess.entity.HierarchyEntity;
import com.japa.Japa.dataAccess.repository.CategoryRepository;
import com.japa.Japa.dataAccess.repository.HierarchyRepository;
import com.japa.Japa.dataAccess.util.ProviderConverter;
import com.japa.Japa.model.Category;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class CategoryDAO {
    private CategoryRepository categoryRepository;
    private HierarchyRepository hierarchyRepository;
    private ProviderConverter providerConverter;

    public CategoryDAO(CategoryRepository categoryRepository, HierarchyRepository hierarchyRepository, ProviderConverter providerConverter){
        this.categoryRepository = categoryRepository;
        this.hierarchyRepository = hierarchyRepository;
        this.providerConverter= providerConverter;
    }

    public List<Category> getCategories(){
        List<HierarchyEntity> hierarchies = hierarchyRepository.findAll();
        List<CategoryEntity> categoriesEntities = categoryRepository.findAll();
        List<Category> categories = new ArrayList<>();
        for(CategoryEntity categoryEntity : categoriesEntities){
            categories.add(providerConverter.categoryEntityToCategoryModel(categoryEntity));
        }
        for(HierarchyEntity hierarchyEntity : hierarchies){
            getRightCategory(categories, hierarchyEntity.getMain_category().getName()).addSubCategory(getRightCategory(categories, hierarchyEntity.getSub_category().getName()));
        }
        categories = categories.stream().filter(category -> category.getSubCategories().size() > 0).collect(Collectors.toList());
        return categories;
    }

    private Category getRightCategory(List<Category> categories, String categoryName){
        return (categories.stream().filter(category -> category.getName().equals(categoryName)).findFirst().orElse(new Category()));
    }
}
