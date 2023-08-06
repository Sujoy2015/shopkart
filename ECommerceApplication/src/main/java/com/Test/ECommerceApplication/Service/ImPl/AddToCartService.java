package com.Test.ECommerceApplication.Service.ImPl;

import com.Test.ECommerceApplication.Entity.AddToCartEntity;
import com.Test.ECommerceApplication.Entity.AdminEntity;
import com.Test.ECommerceApplication.Entity.ProductEntity;
import com.Test.ECommerceApplication.Repository.AddToCartRepository;
import com.Test.ECommerceApplication.Repository.UserLogInRepository;
import com.Test.ECommerceApplication.Service.IAddToCart;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddToCartService implements IAddToCart {

    @Autowired
    private AddToCartRepository addToCartRepository;


    @Override
    public String insert_product_busket(String payloadString) {
        System.out.println(payloadString);
        JSONObject jsonObject = new JSONObject(payloadString);
        AddToCartEntity addToCartEntity = new AddToCartEntity();
//        addToCartEntity.setProductId(Integer.parseInt(jsonObject.get("product_id").toString()));
//        addToCartEntity.setQuantity(Integer.parseInt(jsonObject.get("quantity").toString()));
        addToCartEntity.setProductId(Long.parseLong(jsonObject.get("product_id").toString()));
        addToCartEntity.setQuantity(Integer.parseInt(jsonObject.get("quantity").toString()));
        addToCartEntity.setEmail(jsonObject.get("userEmail").toString());
        addToCartRepository.save(addToCartEntity);
        return "Successfully Inserted";
    }


    public List<AddToCartEntity> getAddToCartByEmail(String email) {
        List<AddToCartEntity> addToCartEntity = (List<AddToCartEntity>) addToCartRepository.getAddtoCartByEmail(email);
        System.out.println("AddToCartEntity"+addToCartEntity.size());
        return addToCartEntity;
    }
    public Optional<AddToCartEntity> getProductId(long id) {
        Optional<AddToCartEntity> productDetails = addToCartRepository.findById(id);
        return productDetails;
    }

    @Override
    public List<AddToCartEntity> getAllBucketData() {
        List<AddToCartEntity> productData = addToCartRepository.findAll();
        return productData;
    }

    @Override
    public String deleteBucketProduct(long cart_id) {
        addToCartRepository.deleteById(cart_id);
        return "successfully deleted..";
    }



}
