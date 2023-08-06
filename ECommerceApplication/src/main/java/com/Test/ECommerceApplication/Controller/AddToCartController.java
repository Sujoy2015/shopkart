package com.Test.ECommerceApplication.Controller;

import com.Test.ECommerceApplication.Entity.AddToCartEntity;
import com.Test.ECommerceApplication.Entity.AdminEntity;
import com.Test.ECommerceApplication.Entity.ProductEntity;
import com.Test.ECommerceApplication.Service.IAddToCart;
import com.Test.ECommerceApplication.Service.IAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class AddToCartController {
    @Autowired
    private IAddToCart iAddToCart;
    @RequestMapping(value ="/insertProductBusket" , method = RequestMethod.POST,consumes = "application/json", produces = "application/json")
    public String insert_product_add(@RequestBody String payload) {
        return iAddToCart.insert_product_busket(payload);
    }

    @RequestMapping(value ="/getProductBucket/{email}" , method = RequestMethod.GET,produces = "application/json")
    public List<AddToCartEntity> getAddtoCartByEmail(@PathVariable String email){
        return iAddToCart.getAddToCartByEmail(email);
    }
    @RequestMapping(value ="/getCardId/{id}" , method = RequestMethod.GET,produces = "application/json")
    public Optional<AddToCartEntity> get_cart_id(@PathVariable long id){
        return iAddToCart.getProductId(id);
    }

    @RequestMapping(value ="/getBucketProduct" , method = RequestMethod.GET , produces = "application/json")
    public List<AddToCartEntity> getAllProducts(){
        return iAddToCart.getAllBucketData();
    }

//    @RequestMapping(value = "/deleteBucketData", method = RequestMethod.DELETE, produces = "application/json")
//    public String deleteBucketData(){
//        return iAddToCart.deleteBucketData();
//    }

    @RequestMapping(value ="/deleteBucketData/{id}" , method = RequestMethod.DELETE)
    public String delete_product(@PathVariable long id){
        return iAddToCart.deleteBucketProduct(id);
    }


}
