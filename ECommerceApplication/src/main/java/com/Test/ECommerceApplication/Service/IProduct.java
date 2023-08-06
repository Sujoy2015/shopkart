package com.Test.ECommerceApplication.Service;

import com.Test.ECommerceApplication.Entity.ProductEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface IProduct {

//    public String insert_data_product(String payloadString, MultipartFile file);
public String insert_data_product(String payloadString);
    public  String deleteProduct(long id);
    public String updateProductDetails(String payload);
    public List<ProductEntity> getAllProducts();

    public Optional<ProductEntity> getProductId(long id);





}
