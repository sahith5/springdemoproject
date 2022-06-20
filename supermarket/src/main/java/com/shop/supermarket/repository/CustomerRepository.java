package com.shop.supermarket.repository;

import com.shop.supermarket.entity.Books;
import com.shop.supermarket.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,String> {

    @Query("select user.books from Customer user where user.username=:username")
    public List<Books> getOrdersList(@Param("username") String username);

//    @Modifying(clearAutomatically = true)
//    @Query("update Users user set user.password =:password,user.email=:email,user.phoneNumber=:phoneNumber,user.address=:address where user.username =:username")
//    public void updateData(@Param("username")String username,@Param("password") String password,@Param("email") String email,@Param("phoneNumber") String phoneNumber,@Param("address") String address);

    public Customer findByUsername(String username);
}
