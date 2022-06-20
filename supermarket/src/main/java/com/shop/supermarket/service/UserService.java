package com.shop.supermarket.service;



import com.shop.supermarket.entity.Books;
import com.shop.supermarket.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public void saveCustomer(Customer customer);
    public List<Customer> getcustomers();
    public void deleteBYId(String id);
    public Optional<Customer> getById(String id);
    public Customer findByUsername(String name);


    public List<Books> getOrdersList(String name);


}
