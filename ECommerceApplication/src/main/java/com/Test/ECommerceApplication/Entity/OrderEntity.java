package com.Test.ECommerceApplication.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="OrderDB")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id",columnDefinition = "bigseries")
    private int id;


    private int product_id;

    @Column(length = 2000)
    private int product_quantity;


    private int product_price;


    private int customer_id;

//    @Column(name = "ddate", nullable = false, updatable = false)
//    @CreationTimestamp
    @CreationTimestamp
    private LocalDateTime order_Date;

    @Column(length = 2000)
    private String status;


    public int getOrder_id() {
        return id;
    }

    public void setOrder_id(int id) {
        this.id = id;
    }



    public int getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(int product_quantity) {
        this.product_quantity = product_quantity;
    }




    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getProduct_price() {
        return product_price;
    }

    public void setProduct_price(int product_price) {
        this.product_price = product_price;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }


    public LocalDateTime getOrder_Date() {
        return order_Date;
    }

    public void setOrder_Date(LocalDateTime order_Date) {
        this.order_Date = order_Date;
    }
}
