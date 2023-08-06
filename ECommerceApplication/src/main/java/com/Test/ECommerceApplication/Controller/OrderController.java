package com.Test.ECommerceApplication.Controller;

import com.Test.ECommerceApplication.Entity.AdminEntity;
import com.Test.ECommerceApplication.Entity.OrderEntity;
import com.Test.ECommerceApplication.Service.IOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class OrderController {

    @Autowired
    private IOrder iOrder;

    @RequestMapping(value ="/addProductInBusket" , method = RequestMethod.POST,consumes = "application/json", produces = "application/json")
    public String addProductBusket(@RequestBody String payload) {
        System.out.println(payload);
        return iOrder.insert_product_busket(payload);
    }

    @RequestMapping(value ="/deleteProductInBusket/{id}" , method = RequestMethod.DELETE ,consumes = "application/json", produces = "application/json")
    public String delete_busket(@PathVariable long id){
        return iOrder.deleteProductBusket(id);
    }


    @RequestMapping(value ="/updateProductInBusket" , method = RequestMethod.PUT)
    public String update_busket(@RequestBody String payload){
        return  iOrder.updateProductBusket(payload);
    }


    @RequestMapping(value ="/getDataInBusket" , method = RequestMethod.GET,produces = "application/json")
    public List<OrderEntity> getAllBusketData(){
        return iOrder.getAllBusketProducts();
    }
}
