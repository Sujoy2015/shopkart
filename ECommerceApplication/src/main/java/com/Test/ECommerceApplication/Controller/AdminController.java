package com.Test.ECommerceApplication.Controller;

import com.Test.ECommerceApplication.Entity.AdminEntity;
import com.Test.ECommerceApplication.Entity.LoginEntity;
import com.Test.ECommerceApplication.Service.IAdmin;
import com.Test.ECommerceApplication.Service.ILogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class AdminController {
    @Autowired
     private IAdmin iAdmin;
//    consumes = "application/json", produces = "application/json"
    @RequestMapping(value ="/insertDataAdmin" , method = RequestMethod.POST,consumes = "application/json", produces = "application/json")
    public String insert_admin_login(@RequestBody String payload) {
        return iAdmin.insert_admin_login(payload);
    }

    //produces = "application/json
    @RequestMapping(value ="/getDataAdmin" , method = RequestMethod.GET,produces = "application/json")
    public List<AdminEntity> getAllAdminDetails(){
        return iAdmin.getAllAdmin();
    }

    @RequestMapping(value="/checkAdmin" , method=RequestMethod.POST , consumes = "application/json")
    public String checkAdminLogin(@RequestBody String payload){
        System.out.println(payload);
        return iAdmin.login_admin(payload);
    }

    @RequestMapping(value="/logoutAdmin" , method=RequestMethod.DELETE , consumes = "application/json")
    public String checkAdminLogout(@RequestBody String payload){
        System.out.println(payload);
        return iAdmin.logout_admin(payload);
    }

}
