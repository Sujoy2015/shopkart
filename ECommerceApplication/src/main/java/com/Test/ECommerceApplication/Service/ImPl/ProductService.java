package com.Test.ECommerceApplication.Service.ImPl;


import com.Test.ECommerceApplication.Entity.ProductEntity;
import com.Test.ECommerceApplication.Repository.ProductRepository;
import com.Test.ECommerceApplication.Service.IProduct;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService implements IProduct {

    @Autowired
    private ProductRepository productrepo;
    @Override
//    public String insert_data_product(String payloadString, @org.jetbrains.annotations.NotNull MultipartFile file) {
    public String insert_data_product(String payloadString) {
        JSONObject jsonObject = new JSONObject(payloadString);
        ProductEntity productEntity = new ProductEntity();
//        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
//
//        if(fileName.contains(".."))
//        {
//            System.out.println("not a a valid file");
//        }
//
//        try {
//            productEntity.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        productEntity.setId(Long.parseLong(jsonObject.get("productId").toString()));
        productEntity.setProductCatagory(jsonObject.get("catagory").toString());
        productEntity.setProductSubCatagory(jsonObject.get("subcatagory").toString());
        productEntity.setProductName(jsonObject.get("name").toString());
        productEntity.setProductBrand(jsonObject.get("brand").toString());
        productEntity.setProductDetails(jsonObject.get("details").toString());
        productEntity.setProductQuantity(Integer.parseInt(jsonObject.get("quantity").toString()));
        productEntity.setProductPrice(Float.parseFloat(jsonObject.get("price").toString()));
        productEntity.setProductDiscount(Integer.parseInt(jsonObject.get("discount").toString()));
        productrepo.save(productEntity);
        return "{\"msg\":\"successfully inserted\"}";
    }

    @Override
    public String deleteProduct(long id) {
        productrepo.deleteById(id);
        return "successfully deleted..";
    }

    @Override
    public String updateProductDetails(String payload) {
        JSONObject jsonObject = new JSONObject(payload);
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(Long.parseLong(jsonObject.get("productId").toString()));
        productEntity.setProductCatagory(jsonObject.get("catagory").toString());
//        productEntity.setProductCatagory(jsonObject.get("subcatagory").toString());
        productEntity.setProductSubCatagory(jsonObject.get("subcatagory").toString());
        productEntity.setProductName(jsonObject.get("name").toString());
        productEntity.setProductBrand(jsonObject.get("brand").toString());
        productEntity.setProductDetails(jsonObject.get("details").toString());
        productEntity.setProductQuantity(Integer.parseInt(jsonObject.get("quantity").toString()));
        productEntity.setProductPrice(Float.parseFloat(jsonObject.get("price").toString()));
        productEntity.setProductDiscount(Integer.parseInt(jsonObject.get("discount").toString()));
        productrepo.save(productEntity);
        return "update";
    }

    @Override
    public List<ProductEntity> getAllProducts() {
        List<ProductEntity> productData = productrepo.findAll();
        return productData;
    }

    public Optional<ProductEntity> getProductId(long id) {
        Optional<ProductEntity> productDetails = productrepo.findById(id);
        return productDetails;
    }
}
