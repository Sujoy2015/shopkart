package com.Test.ECommerceApplication.Repository;

import com.Test.ECommerceApplication.Entity.AddToCartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface AddToCartRepository extends JpaRepository<AddToCartEntity,Long> {
//    List<AddToCartEntity> findByEmail(String email);
    @Query(value = "SELECT * FROM addtocart u WHERE u.email =:email",nativeQuery = true)
    Collection<AddToCartEntity> getAddtoCartByEmail(@Param("email")String email);

    @Query(value="delete from addtocart where cartId = : cart_id",nativeQuery = true)
    public AddToCartEntity deleteBucketData(@Param("cart_id")Long cartId);
}
