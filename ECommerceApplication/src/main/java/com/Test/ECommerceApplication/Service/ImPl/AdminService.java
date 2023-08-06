package com.Test.ECommerceApplication.Service.ImPl;

import com.Test.ECommerceApplication.Entity.AdminEntity;
import com.Test.ECommerceApplication.Repository.AdminRepository;
import com.Test.ECommerceApplication.Service.IAdmin;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AdminService implements IAdmin  {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public String insert_admin_login(String payloadString) {
        JSONObject jsonObject = new JSONObject(payloadString);
        AdminEntity adminEntity = new AdminEntity();
        adminEntity.setName(jsonObject.get("name").toString());
        adminEntity.setEmail(jsonObject.get("email").toString());
        adminEntity.setPassword(jsonObject.get("password").toString());
        adminEntity.setConfirmPassword(jsonObject.get("confirm_password").toString());
        adminEntity.setPhone(jsonObject.get("phone").toString());
        adminEntity.setCountry(jsonObject.get("country").toString());
        adminEntity.setAddress(jsonObject.get("address").toString());
        adminEntity.setPincode(jsonObject.get("pincode").toString());

        adminRepository.save(adminEntity);
        return "successfully inserted into admin database";
    }

    @Override
    public List<AdminEntity> getAllAdmin() {
        List<AdminEntity> adminuser = adminRepository.findAll();
        return  adminuser;
    }

    @Override
    public String login_admin(String payload) {
      JSONObject jsonObject = new JSONObject(payload);

      String email = jsonObject.get("email").toString();
      String password = jsonObject.get("password").toString();


     AdminEntity adminEntity =  adminRepository.checkLogin(email, password);
     if(adminEntity != null && adminEntity.getEmail() != null)
     {
         return "Succesfully Login";
     }
     else{
         return "Not succesfully Login";
     }

    }

    @Override
    public String logout_admin(String payload) {
        JSONObject jsonObject = new JSONObject(payload);

        String email = jsonObject.get("email").toString();
        String password = jsonObject.get("password").toString();

        AdminEntity adminEntity = adminRepository.checkLogout(email, password);

        if(adminEntity != null && adminEntity.getEmail() != null && adminEntity.getPassword() != null)
        {
            return "Succesfully Logout";
        }
        else{
            return "Not succesfully Logout";
        }
    }

    @Override
    public String deleteAdmin(long id) {
        adminRepository.deleteById(id);
        return "deleted";
    }

    @Override
    public String updateAdminDetails(String payload) {
        JSONObject jsonObject = new JSONObject(payload);
        AdminEntity adminEntity = new AdminEntity();
        adminEntity.setId(Long.parseLong(jsonObject.get("id").toString()));
        adminEntity.setName(jsonObject.get("name").toString());
        adminEntity.setEmail(jsonObject.get("email").toString());
        adminEntity.setPassword(jsonObject.get("password").toString());
        adminEntity.setConfirmPassword(jsonObject.get("confirm_password").toString());
        adminEntity.setPhone(jsonObject.get("phone").toString());
        adminEntity.setCountry(jsonObject.get("country").toString());
        adminEntity.setAddress(jsonObject.get("address").toString());
        adminEntity.setPincode(jsonObject.get("pincode").toString());

        adminRepository.save(adminEntity);
        return "Successfully updated";
    }



}
