package com.japa.Japa.dataAccess.dao;

import com.japa.Japa.dataAccess.entity.OrderEntity;
import com.japa.Japa.dataAccess.entity.ProductEntity;
import com.japa.Japa.dataAccess.entity.ProductLineEntity;
import com.japa.Japa.dataAccess.interfaceDAO.IProductLineDAO;
import com.japa.Japa.dataAccess.repository.ProductLineRepository;
import com.japa.Japa.dataAccess.util.ProviderConverter;
import com.japa.Japa.model.CommandLine;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class ProductLineDAO implements IProductLineDAO {
    private ProductLineRepository productLineRepository;
    private ProviderConverter providerConverter;

    public ProductLineDAO(ProductLineRepository productLineRepository, ProviderConverter providerConverter){
        this.productLineRepository = productLineRepository;
        this.providerConverter = providerConverter;
    }

    public void saveProductLine(CommandLine commandLine, int line, OrderEntity orderEntity, ProductEntity productEntity){
        ProductLineEntity productLineEntity = providerConverter.productLineModelToProductLineEntity(commandLine, line, orderEntity, productEntity);
        productLineRepository.save(productLineEntity);
    }
}
