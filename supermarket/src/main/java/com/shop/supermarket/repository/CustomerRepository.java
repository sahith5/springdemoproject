package com.shop.supermarket.repository;

import com.shop.supermarket.entity.Books;
import com.shop.supermarket.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,String> {

    @Query("select user.books from Customer user where user.username=:username")
    public List<Books> getOrdersList(@Param("username") String username);

//    public  List<Books> getAllBooksByUsername(String username);

    public Customer findByUsername(String username);
}
