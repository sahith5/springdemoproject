package com.shop.supermarket.service;


import com.shop.supermarket.entity.Roles;
import com.shop.supermarket.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class RoleServiceImpl implements RoleService{

    @Autowired
    RolesRepository rolesRepository;

    @Override
    public Optional<Roles> getRolesById(String id) {
        return rolesRepository.findById(id);
    }


    @Override
    public void saveRole(Roles role) {
        rolesRepository.save(role);
    }
}
