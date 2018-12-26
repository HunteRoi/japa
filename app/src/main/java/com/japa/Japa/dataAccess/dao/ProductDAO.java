package com.japa.Japa.dataAccess.dao;

import com.japa.Japa.dataAccess.entity.CategoryEntity;
import com.japa.Japa.dataAccess.entity.HierarchyEntity;
import com.japa.Japa.dataAccess.entity.ProductEntity;
import com.japa.Japa.dataAccess.repository.CategoryRepository;
import com.japa.Japa.dataAccess.repository.HierarchyRepository;
import com.japa.Japa.dataAccess.repository.ProductRepository;
import com.japa.Japa.dataAccess.util.ProviderConverter;
import com.japa.Japa.model.Product;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class ProductDAO {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private HierarchyRepository hierarchyRepository;
    private ProviderConverter providerConverter;

    public ProductDAO(ProductRepository productRepository, CategoryRepository categoryRepository, HierarchyRepository hierarchyRepository, ProviderConverter providerConverter){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.hierarchyRepository = hierarchyRepository;
        this.providerConverter = providerConverter;
    }

    public List<Product> getAllProducts(String mainCategory,String language){
        List<Product> products = new ArrayList<>();
        List<ProductEntity> filteredProductEntities = new ArrayList<>();
        List<ProductEntity> productEntities = productRepository.findAll();
        List<HierarchyEntity> hierarchyEntities = hierarchyRepository.findAll();
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();

        CategoryEntity mainCategoryEntity = categoryEntities.stream().filter(categoryEntity -> categoryEntity.getName().toLowerCase().equals(mainCategory)).findFirst().orElse(null);
        hierarchyEntities = hierarchyEntities.stream().filter(hierarchyEntity -> hierarchyEntity.getMain_category().equals(mainCategoryEntity)).collect(Collectors.toList());

        if(mainCategoryEntity.getHas_no_children()){
            filteredProductEntities = productEntities.stream().filter(productEntity -> productEntity.getCategory().equals(mainCategoryEntity)).collect(Collectors.toList());
        }
        else{
            for (HierarchyEntity hierarchyEntity : hierarchyEntities) {
                filteredProductEntities.addAll(productEntities.stream().filter(productEntity -> productEntity.getCategory().getCategory_id() == hierarchyEntity.getSub_category().getCategory_id()).collect(Collectors.toList()));
            }
        }

        for (ProductEntity productEntity : filteredProductEntities) {
            products.add(providerConverter.productEntityToProductModel(productEntity, language));
        }

        return products;
    }

    public List<Product> getProductsBySubCategory(String mainCategory, String Subcategory, String language){
        List<Product> products = new ArrayList<>();
        List<ProductEntity> categoryProductEntities = getProductsOfSubCategory(mainCategory,Subcategory);
        for(ProductEntity productEntity : categoryProductEntities){
            products.add(providerConverter.productEntityToProductModel(productEntity, language));
        }
        return products;
    }


    private List<ProductEntity> getProductsOfSubCategory(String mainCategory, String category){
        List<ProductEntity> productEntities = productRepository.findAll();
        List<HierarchyEntity> hierarchyEntities = hierarchyRepository.findAll();
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();

        CategoryEntity mainCategoryEntity = categoryEntities.stream().filter(categoryEntity -> categoryEntity.getName().toLowerCase().equals(mainCategory)).findFirst().orElse(null);
        hierarchyEntities = hierarchyEntities.stream().filter(hierarchyEntity -> hierarchyEntity.getMain_category().equals(mainCategoryEntity)).collect(Collectors.toList());
        HierarchyEntity categoryEntity =  hierarchyEntities.stream().filter(hierarchyEntity -> hierarchyEntity.getSub_category().getName().toLowerCase().equals(category)).findFirst().orElse(null);

        int categoryId = categoryEntity.getSub_category().getCategory_id();

        List<Product> products = new ArrayList<>();
        return productEntities.stream().filter(productEntity -> productEntity.getCategory().getCategory_id() == categoryId).collect(Collectors.toList());
    }



}
