package com.Test.ECommerceApplication.Service.ImPl;

import com.Test.ECommerceApplication.Entity.OrderEntity;
import com.Test.ECommerceApplication.Repository.OrderRepository;
import com.Test.ECommerceApplication.Service.IOrder;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrder {

    @Autowired
    private OrderRepository orderRepository;
    @Override
    public String insert_product_busket(String payloadString) {

        JSONObject jsonObject = new  JSONObject(payloadString);
        OrderEntity order = new OrderEntity();
//        order.setOrder_id(Integer.parseInt(jsonObject.get("order_id").toString()));
        order.setProduct_id(Integer.parseInt(jsonObject.get("product_id").toString()));
        order.setCustomer_id(Integer.parseInt(jsonObject.get("customer_id").toString()));
        order.setProduct_price(Integer.parseInt(jsonObject.get("product_price").toString()));
        order.setProduct_quantity(Integer.parseInt(jsonObject.get("product_quantity").toString()));
        order.setStatus(jsonObject.get("status").toString());

        System.out.println(jsonObject.get("product_id").toString());
        orderRepository.save(order);

        return "insert data in busket";
    }

    @Override
    public List<OrderEntity> getAllBusketProducts() {
        List<OrderEntity>orders = orderRepository.findAll();

        return orders;
    }

    @Override
    public String deleteProductBusket(long id) {
        orderRepository.deleteById(id);
        return "delete product from busket";
    }

    @Override
    public String updateProductBusket(String payload) {
        JSONObject jsonObject = new  JSONObject(payload);
        OrderEntity order = new OrderEntity();
        order.setOrder_id(Integer.parseInt(jsonObject.get("id").toString()));
        order.setProduct_id(Integer.parseInt(jsonObject.get("product_id").toString()));
        order.setCustomer_id(Integer.parseInt(jsonObject.get("customer_id").toString()));
        order.setProduct_price(Integer.parseInt(jsonObject.get("product_price").toString()));
        order.setProduct_quantity(Integer.parseInt(jsonObject.get("product_quantity").toString()));
        order.setStatus(jsonObject.get("status").toString());

        System.out.println(jsonObject.get("product_id").toString());
        orderRepository.save(order);

        return "update data in busket";
    }
}
