package com.Test.ECommerceApplication.Repository;

import com.Test.ECommerceApplication.Entity.AdminEntity;
import com.Test.ECommerceApplication.Entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdminRepository extends JpaRepository<AdminEntity,Long> {

    @Query(value="select * from admin where email = :email and password =:password ",nativeQuery = true)
    public AdminEntity checkLogin(@Param("email")String email, @Param("password")String password);

    @Query(value="delete from admin where email = :email and password =:password ",nativeQuery = true)
    public AdminEntity checkLogout(@Param("email")String email, @Param("password")String password);

}
