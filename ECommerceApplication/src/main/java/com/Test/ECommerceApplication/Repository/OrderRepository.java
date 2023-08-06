package com.Test.ECommerceApplication.Repository;

import com.Test.ECommerceApplication.Entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity,Long> {
}
