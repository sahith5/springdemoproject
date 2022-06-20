package com.shop.supermarket.service;


import com.shop.supermarket.entity.Books;
import com.shop.supermarket.entity.Customer;
import com.shop.supermarket.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    CustomerRepository customerRepository;
    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    @Transactional
    public List<Customer> getcustomers() {
        return customerRepository.findAll();

    }

    @Override
    public void deleteBYId(String id) {

        customerRepository.deleteById(id);


    }

    @Override
    public Optional<Customer> getById(String id) {

        return customerRepository.findById(id);
    }


    @Override
    public Customer findByUsername(String username) {
        return customerRepository.findByUsername(username);
    }

    @Override
    public List<Books> getOrdersList(String name) {
        return customerRepository.getOrdersList(name);
    }


//
//    @Override
//    public List<Books> getOrdersList(String username) {
//        return customerRepository.getOrdersList(username);
//    }
}
