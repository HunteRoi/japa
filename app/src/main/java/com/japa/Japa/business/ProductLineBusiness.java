package com.japa.Japa.business;

import com.japa.Japa.dataAccess.dao.ProductLineDAO;
import com.japa.Japa.dataAccess.entity.OrderEntity;
import com.japa.Japa.dataAccess.entity.ProductEntity;
import com.japa.Japa.model.CommandLine;

public class ProductLineBusiness {
    private ProductLineDAO productLineDAO;

    public ProductLineBusiness(ProductLineDAO productLineDAO){
        this.productLineDAO = productLineDAO;
    }

    public void saveProductLine(CommandLine commandLine, int line, OrderEntity orderEntity, ProductEntity productEntity){
        this.productLineDAO.saveProductLine(commandLine, line, orderEntity, productEntity);
    }
}
