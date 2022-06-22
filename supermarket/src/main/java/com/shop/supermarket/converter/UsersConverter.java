package com.shop.supermarket.converter;


import com.shop.supermarket.dto.Customerdto;
import com.shop.supermarket.entity.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsersConverter {


    @Autowired
    private ModelMapper modelMapper;

    public Customerdto entityToDto(Customer users)
    {
        return modelMapper.map(users,Customerdto.class);
    }

    public List<Customerdto> entityToDto(List<Customer> users)
    {
        return users.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public Customer dtoToEntity(Customerdto usersDTO)
    {
        return modelMapper.map(usersDTO,Customer.class);
    }

}
