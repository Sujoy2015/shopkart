package com.Test.ECommerceApplication.Controller;

import com.Test.ECommerceApplication.Entity.ProductEntity;
import com.Test.ECommerceApplication.Entity.VendorEntity;
import com.Test.ECommerceApplication.Service.IProduct;
import com.Test.ECommerceApplication.Service.IVendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class ProductController {

    @Autowired
    private IProduct iProduct;


//    @RequestMapping(value ="/insertProduct" , method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
//    public String insert_product(@RequestBody String payloadString,@RequestBody MultipartFile file){
//        return  iProduct.insert_data_product(payloadString,file);
//    }

    @RequestMapping(value ="/insertProduct" , method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public String insert_product(@RequestBody String payloadString){
        return  iProduct.insert_data_product(payloadString);
    }
    @RequestMapping(value ="/getProduct" , method = RequestMethod.GET , produces = "application/json")
    public List<ProductEntity> getAllProducts(){
        return iProduct.getAllProducts();
    }

    @RequestMapping(value ="/deleteProduct/{id}" , method = RequestMethod.DELETE)
    public String delete_product(@PathVariable long id){
        return iProduct.deleteProduct(id);
    }


    @RequestMapping(value ="/updateProduct" , method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public String update_product(@RequestBody String payload){
        return  iProduct.updateProductDetails(payload);
    }

    @RequestMapping(value ="/getProductId/{id}" , method = RequestMethod.GET,produces = "application/json")
    public Optional<ProductEntity> get_product_id(@PathVariable long id){
        return iProduct.getProductId(id);
    }
}
