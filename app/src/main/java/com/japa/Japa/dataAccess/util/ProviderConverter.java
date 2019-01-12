package com.japa.Japa.dataAccess.util;

import com.japa.Japa.dataAccess.dao.ProductDAO;
import com.japa.Japa.dataAccess.entity.*;
import com.japa.Japa.model.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Component
public class ProviderConverter {

    public Category categoryEntityToCategoryModel(CategoryEntity categoryEntity){
        Category category = new Category();
        category.setName(categoryEntity.getName());
        category.setId(categoryEntity.getCategory_id());
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

    public OrderEntity orderModelToOrderEntity(Order order){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserEntity current_user = (UserEntity) authentication.getPrincipal();

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrder_date(dateUtilToDateSql(order.getOrderDate()));
        orderEntity.setPurchase_date(order.getPurchaseDate() == null? null : dateUtilToDateSql(order.getPurchaseDate()));
        orderEntity.setUser_id(current_user);
        return orderEntity;
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
        promotion.setStartDate(dateSqlToDateUtil(promotionEntity.getStart_date()));
        promotion.setEndDate(dateSqlToDateUtil(promotionEntity.getEnd_date()));
        promotion.setPromotion_id(promotionEntity.getPromotion_id());
        return promotion;
    }

    public ProductLineEntity productLineModelToProductLineEntity(CommandLine commandLine, int line, OrderEntity orderEntity, ProductEntity productEntity){
        ProductLineEntity productLineEntity = new ProductLineEntity();
        productLineEntity.setQuantity(commandLine.getQuantity());
        productLineEntity.setOrder_product_price(commandLine.getPriceWithDiscount());
        productLineEntity.setLine_number(line);
        productLineEntity.setOrder(orderEntity);
        productLineEntity.setProduct(productEntity);
        return productLineEntity;
    }

    public UserEntity userModelToUserEntity(User user){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(Encryption.encrypt(user.getPassword()));
        userEntity.setFirst_name(user.getFirstName());
        userEntity.setLast_name(user.getLastName());
        userEntity.setEmail(user.getEmail());
        userEntity.setPhone_number(user.getPhoneNumber());
        userEntity.setAddress(user.getAddress());
        userEntity.setAuthorities("ROLE_USER");
        userEntity.setNon_expired(true);
        userEntity.setNon_locked(true);
        userEntity.setCredentials_non_expired(true);
        userEntity.setEnabled(true);
        return userEntity;
    }

    public Date dateSqlToDateUtil(java.sql.Date date){
        return new Date(date.getTime());
    }

    public java.sql.Date dateUtilToDateSql(Date date){
        return new java.sql.Date(date.getTime());
    }
}