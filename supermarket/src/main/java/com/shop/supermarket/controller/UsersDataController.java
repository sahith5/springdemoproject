package com.shop.supermarket.controller;


import com.shop.supermarket.converter.ItemsConverter;
import com.shop.supermarket.converter.UsersConverter;
import com.shop.supermarket.entity.Books;
import com.shop.supermarket.entity.Customer;
import com.shop.supermarket.service.RolesService;
import com.shop.supermarket.service.UserService;
import com.shop.supermarket.service.Bookservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UsersDataController {

    @Autowired
    private UserService usersService;

    @Autowired
    private Bookservice itemsService;


    @Autowired
    private RolesService rolesService;

    @Autowired
    private ItemsConverter itemsConverter;

    @Autowired
    private UsersConverter usersConverter;



    @Autowired
    private Bookservice bookService;



    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @GetMapping("/ordersList")
    public String ordersList(Principal loginUser, Model theModel) {
        theModel.addAttribute("currentUser", loginUser.getName());
        theModel.addAttribute("orderedItems", itemsConverter.entityToDto(usersService.getOrdersList(loginUser.getName())));
        return "orders-list";
    }


    @GetMapping("/order")
    public String order(Model theModel) {
        theModel.addAttribute("items", itemsConverter.entityToDto(itemsService.getbooks()));
        return "order-item";
    }


    @PostMapping("/orderItem")
    public ModelAndView orderItem(@RequestParam String itemId, Principal loggedUser) {
        Customer user = usersService.findByUsername(loggedUser.getName());
        Books item = itemsService.getBookById(Integer.parseInt(itemId));
        user.addItem(item);
        itemsService.saveBook(item);
        return new ModelAndView("redirect:/successHandler");
    }


    @PostMapping("/deleteOrder")
    public ModelAndView deleteItem(@RequestParam int id, Principal loggedUser) {
        Customer user = usersService.findByUsername(loggedUser.getName());
        Books item = itemsService.getBookById(id);
        user.getBooks().remove(item);
        itemsService.saveBook(item);
        return new ModelAndView("redirect:/user/ordersList");
    }

}




