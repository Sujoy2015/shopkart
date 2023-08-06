package com.Test.ECommerceApplication.Repository;

import com.Test.ECommerceApplication.Entity.AdminEntity;
import com.Test.ECommerceApplication.Entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserLogInRepository  extends JpaRepository<LoginEntity,Long>{

    @Query(value="select * from users where user_email = :userEmail and user_password =:userPassword",nativeQuery = true)
    public LoginEntity checkLogin(@Param("userEmail")String userEmail, @Param("userPassword")String userPassword);

    @Query(value="delete from users where user_email = :userEmail and user_password =:userPassword",nativeQuery = true)
    public LoginEntity checkLogout(@Param("userEmail")String userEmail, @Param("userPassword")String userPassword);


}
