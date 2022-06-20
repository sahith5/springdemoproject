package com.shop.supermarket.controller;


import com.shop.supermarket.entity.Books;
import com.shop.supermarket.entity.Customer;
import com.shop.supermarket.service.RolesService;
import com.shop.supermarket.service.UserService;
import com.shop.supermarket.service.bookservice;
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
    private bookservice itemsService;


    @Autowired
    private RolesService rolesService;
    @Autowired
    private bookservice bookService;


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @GetMapping("/ordersList")
    public String ordersList(Principal loginUser, Model theModel) {
        theModel.addAttribute("currentUser", loginUser.getName());
        theModel.addAttribute("orderedItems", usersService.getOrdersList(loginUser.getName()));
        return "orders-list";
    }


    @GetMapping("/order")
    public String order(Model theModel) {
        theModel.addAttribute("items", itemsService.getbooks());
        return "order-item";
    }


    @PostMapping("/orderItem")
    public ModelAndView orderItem(@RequestParam String itemId, Principal loggedUser) {
        Customer user = usersService.findByUsername(loggedUser.getName());
        Books item = itemsService.getBookById(Integer.parseInt(itemId));
        System.out.println(user);
        System.out.println(item);
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




//
//
//
//    @GetMapping("/updatePage")
//    public String updatePage(Model model,Principal currentLoggedUser)
//    {
//        UsersDTO tempUser = usersConverter.entityToDto(usersService.findByUsername(currentLoggedUser.getName()));
//        model.addAttribute("user",tempUser);
//        return "update-page";
//    }
//
//
//    @PostMapping("/saveUser")
//    public String saveUser(@Valid @ModelAttribute("user") UsersDTO user, BindingResult bindingResult, Model model,Principal presentUser)
//    {
//        if(bindingResult.hasErrors())
//        {
//            model.addAttribute("loggedUser",presentUser.getName());
//            model.addAttribute("user",user);
//            return "update-page";
//        }
//        Users tempUser = usersConverter.dtoToEntity(user);
//        String encodedPassword = bCryptPasswordEncoder.encode(tempUser.getPassword());
//        usersService.updateUser(presentUser.getName(),encodedPassword,tempUser.getEmail(),tempUser.getPhoneNumber(),tempUser.getAddress());
//        return "redirect:/successHandler";
//    }
//}
