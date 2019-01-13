package com.japa.Japa.dataAccess.interfaceDAO;

import com.japa.Japa.dataAccess.entity.OrderEntity;
import com.japa.Japa.dataAccess.entity.ProductEntity;
import com.japa.Japa.model.CommandLine;

public interface IProductLineDAO {
    void saveProductLine(CommandLine commandLine, int line, OrderEntity orderEntity, ProductEntity productEntity);
}
