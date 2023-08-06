package com.Test.ECommerceApplication.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="admin")
public class AdminEntity {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column(length=2000)
    private String name;
    @Column(length=2000)
    private String email;
    @Column(length=2000)
    private String password;
    @Column(length=2000)
    private String confirmPassword;

    @Column(length=2000)
    public String phone;

//    @JsonFormat(pattern="dd-MM-yyyy")
//    @Column(length = 2000)
//    private LocalDateSerializer dob;
    @Column(length=2000)
    private String country;
    @Column(length=2000)
    private String address;
    @Column(length=2000)
    private String pincode;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }




    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }




}
