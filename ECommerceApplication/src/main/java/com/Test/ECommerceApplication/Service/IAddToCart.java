package com.Test.ECommerceApplication.Service;

import com.Test.ECommerceApplication.Entity.AddToCartEntity;
import com.Test.ECommerceApplication.Entity.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface IAddToCart {

    public String insert_product_busket(String payloadString);
    public List<AddToCartEntity> getAddToCartByEmail(String email);

    public Optional<AddToCartEntity> getProductId(long id);

    public List<AddToCartEntity> getAllBucketData();

    public String deleteBucketProduct(long id);
}
