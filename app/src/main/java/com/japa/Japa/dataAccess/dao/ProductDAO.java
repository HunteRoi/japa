package com.japa.Japa.dataAccess.dao;

import com.japa.Japa.dataAccess.entity.ProductEntity;
import com.japa.Japa.dataAccess.entity.ProductTranslationEntity;
import com.japa.Japa.dataAccess.repository.ProductRepository;
import com.japa.Japa.dataAccess.repository.ProductTranslationRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ProductDAO {
    private ProductRepository productRepository;
    private ProductTranslationRepository productTranslationRepository;

    public ProductDAO(ProductRepository productRepository, ProductTranslationRepository productTranslationRepository){
        this.productRepository = productRepository;
        this.productTranslationRepository = productTranslationRepository;
    }

    public void test(){
        List<ProductEntity> productEntities = productRepository.findAll();
        for(ProductEntity productEntity : productEntities){
            System.out.println(productEntity.getProduct_price());
            for(ProductTranslationEntity productTranslationEntity : productEntity.getTranslationEntities()){
                System.out.println(productTranslationEntity.getName());
                System.out.println(productTranslationEntity.getDescription());
            }
        }
    }

}
