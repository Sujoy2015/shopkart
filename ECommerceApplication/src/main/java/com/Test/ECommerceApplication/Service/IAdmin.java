package com.Test.ECommerceApplication.Service;

import com.Test.ECommerceApplication.Entity.AdminEntity;
//import com.Test.ECommerceApplication.Entity.LoginEntity;

import java.util.List;

public interface IAdmin {
    public String insert_admin_login(String payloadString);
     public List<AdminEntity> getAllAdmin();
    public  String deleteAdmin(long id);
    public String updateAdminDetails(String payload);
//
    public String login_admin(String payload);

    public String logout_admin(String payload);
}
