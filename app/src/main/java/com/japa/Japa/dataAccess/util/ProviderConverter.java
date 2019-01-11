package com.japa.Japa.dataAccess.util;

import com.japa.Japa.dataAccess.entity.*;
import com.japa.Japa.model.Category;
import com.japa.Japa.model.Product;
import com.japa.Japa.model.Promo;
import com.japa.Japa.model.Promotion;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Date;

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

    public Promo promoEntityToPromoModel(PromoEntity promoEntity, String language){
        Promo promo = new Promo();
        promo.setPromotion(promotionEntityToPromotionModel(promoEntity.getPromotion()));
        promo.setProduct(productEntityToProductModel(promoEntity.getProduct(), language));
        return promo;
    }

    public Promotion promotionEntityToPromotionModel(PromotionEntity promotionEntity){
        Promotion promotion = new Promotion();
        promotion.setPourcent(promotionEntity.getPourcent());
        promotion.setStartDate(dataSqlToDateUtil(promotionEntity.getStart_date()));
        promotion.setEndDate(dataSqlToDateUtil(promotionEntity.getEnd_date()));
        promotion.setPromotion_id(promotionEntity.getPromotion_id());
        return promotion;
    }

    public Date dataSqlToDateUtil(java.sql.Date date){
        return new Date(date.getTime());
    }


}
