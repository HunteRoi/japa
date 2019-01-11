package com.japa.Japa.dataAccess.util;

import com.japa.Japa.dataAccess.entity.CategoryEntity;
import com.japa.Japa.dataAccess.entity.ProductEntity;
import com.japa.Japa.dataAccess.entity.ProductTranslationEntity;
import com.japa.Japa.model.Category;
import com.japa.Japa.model.Product;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class ProviderConverter {

    public Category categoryEntityToCategoryModel(CategoryEntity categoryEntity){
        Category category = new Category();
        category.setName(categoryEntity.getName());
        category.setHasNoChildren(categoryEntity.getHas_no_children());
        return category;
    }

    public Product productEntityToProductModel(ProductEntity productEntity, String language){
        Product product = new Product();
        ProductTranslationEntity translation = new ProductTranslationEntity();

        Collection<ProductTranslationEntity> translationEntities = productEntity.getTranslationEntities();
        if(language.equals("en")) translation = translationEntities.stream().filter(translationEntity -> translationEntity.getLanguage().getName().equals("English")).findFirst().orElse(null);
        else if(language.equals("fr")) translation = translationEntities.stream().filter(translationEntity -> translationEntity.getLanguage().getName().equals("Français")).findFirst().orElse(null);

        product.setProductPrice(productEntity.getProduct_price());
        product.setImageUrl(productEntity.getImage_url());
        product.setId(productEntity.getProduct_id());
        product.setName(translation.getName());
        product.setDescription(translation.getDescription());
        product.setCategory(categoryEntityToCategoryModel(productEntity.getCategory()));
        return  product;
    }


}
