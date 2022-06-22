package com.shop.supermarket.controller;



import com.shop.supermarket.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.security.Principal;

@Controller
public class BasicController {
    @Autowired
    private UserService usersService;

    @Autowired
    private Bookservice itemsService;


    @Autowired
    private RolesService rolesService;
    @Autowired
    private Bookservice bookService;



    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;





    @GetMapping("/loginPage")
    public String login()
    {
        return "login-page";
    }

    @GetMapping("/successHandler")
    public String successHandler(Principal loggedUser, Model theModel)
    {
        theModel.addAttribute("loggedUser",loggedUser.getName());
        theModel.addAttribute("items",bookService.getbooks());
        return "home";
    }

    @GetMapping("/access-denied")
    public String failHandler()
    {
        return "denied";
    }


    @GetMapping("/role")
    public String role()
    {
        return "role-page";
    }


}
