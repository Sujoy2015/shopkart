package com.Test.ECommerceApplication.Service;

import com.Test.ECommerceApplication.Entity.LoginEntity;
import com.Test.ECommerceApplication.Entity.OrderEntity;

import java.util.List;

public interface IOrder {

    public String insert_product_busket(String payloadString);
    public List<OrderEntity> getAllBusketProducts();
    public  String deleteProductBusket(long id);
    public String updateProductBusket(String payload);
}
