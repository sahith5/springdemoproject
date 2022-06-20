package com.shop.supermarket.controller;



import com.shop.supermarket.entity.Books;
import com.shop.supermarket.service.UserService;
import com.shop.supermarket.service.bookservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/staff")
public class StaffDataController {

    @Autowired
    private UserService usersServiceObject;

    @Autowired
    private bookservice itemsServiceObject;



    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoderObject;
    static final String SUCCESS_HANDLER = "redirect:/successHandler";

    @GetMapping("/stockList")
    public String stockList(Model theModel) {
        theModel.addAttribute("allItems", itemsServiceObject.getbooks());
        return "stock-list";
    }

    @PostMapping("/deleteItem")
    public ModelAndView deleteItem(@RequestParam int id) {
        itemsServiceObject.deleteById(id);
        return new ModelAndView("redirect:/staff/stockList");
    }

    //
//
//    @GetMapping("/updateStaffPage")
//    public String updatePage(Model model,Principal loggedUser)
//    {
//        UsersDTO tempUser = usersConverterObject.entityToDto(usersServiceObject.findByUsername(loggedUser.getName()));
//        model.addAttribute("user",tempUser);
//        return "update-staff-page";
//    }
//
//
//    @PostMapping("/saveUser")
//    public String saveUser(@Valid @ModelAttribute("user") UsersDTO user, BindingResult bindingResult, Model model,Principal loggedUser)
//    {
//        if(bindingResult.hasErrors())
//        {
//            model.addAttribute("error",bindingResult.getFieldError("id"));
//            model.addAttribute("user",user);
//            return "update-staff-page";
//        }
//        Users tempUser = usersConverterObject.dtoToEntity(user);
//        String encodedPassword = bCryptPasswordEncoderObject.encode(tempUser.getPassword());
//        usersServiceObject.updateUser(loggedUser.getName(),encodedPassword,tempUser.getEmail(),tempUser.getPhoneNumber(),tempUser.getAddress());
//
//        return SUCCESS_HANDLER;
//    }
//
//
    @GetMapping("/addItem")
    public String addNewItem()
    {
        return "item-form";
    }

    @PostMapping("/saveItem")
    public String saveNewItem(@Valid @ModelAttribute("item") Books book)
    {
        itemsServiceObject.saveBook(book);
        return SUCCESS_HANDLER;
    }

    @PostMapping("/updateItem")
    public String updateItem(@Valid @RequestParam("itemId") int itemId, Model model) {
        model.addAttribute("item", itemsServiceObject.getBookById(itemId));
        return "item-update";
    }
}














//}
