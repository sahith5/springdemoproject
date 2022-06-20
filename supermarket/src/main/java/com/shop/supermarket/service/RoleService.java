package com.shop.supermarket.service;


import com.shop.supermarket.entity.Roles;

import java.util.Optional;

public interface RoleService {

        public Optional<Roles> getRolesById(String id);
        public void saveRole(Roles role);

}
