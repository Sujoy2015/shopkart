package com.Test.ECommerceApplication.Entity;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="addtocart")
public class AddToCartEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long cartId;

    @Column(length=2000)
    private long productId;

    @Column(length = 2000)
    private int quantity;

    @Column(length=2000)
    private String email;
    @Column(length=2000)
    @CreationTimestamp
    private LocalDateTime orderDate;


    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
