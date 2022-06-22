package com.shop.supermarket.controller;



import com.shop.supermarket.converter.ItemsConverter;
import com.shop.supermarket.converter.UsersConverter;
import com.shop.supermarket.dto.Booksdto;

import com.shop.supermarket.service.UserService;
import com.shop.supermarket.service.Bookservice;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/staff")
public class StaffDataController {

    @Autowired
    private UserService usersServiceObject;

    @Autowired
    private Bookservice itemsServiceObject;

    @Autowired
    private ItemsConverter itemsConverter;

    @Autowired
    private UsersConverter usersConverter;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoderObject;
    private ItemsConverter itemsConverterObject;
    private Bookservice itemsService;

    @Autowired
    public void setItemsServiceObject(Bookservice itemsServiceObject)
    {
        this.itemsService=itemsServiceObject;
    }

    @Autowired
    public void setItemsConverterObject(ItemsConverter itemsConverterObject)
    {
        this.itemsConverterObject=itemsConverterObject;
    }


    @GetMapping("/stockList")
    public String stockList( Model theModel) {
        theModel.addAttribute("allItems", itemsServiceObject.getbooks());
        return "stock-list";
    }



    @PostMapping("/deleteItem")
    public ModelAndView deleteItem(@RequestParam int id) {
        itemsServiceObject.deleteById(id);
        return new ModelAndView("redirect:/successHandler");

    }


    @GetMapping("/addItem")
    public String addNewItem()
    {
        return "item-form";
    }


    @PostMapping("/saveItem")
    public ModelAndView saveNewItem(@ModelAttribute("item") Booksdto book)
    {
        itemsServiceObject.saveBook(itemsConverter.dtoToEntity(book));
        return new ModelAndView("redirect:/successHandler");
    }

    @PostMapping("/updateItem")
    public String updateItem( @RequestParam("itemId") int itemId,  Model model) {
        model.addAttribute("item",itemsConverter.entityToDto(itemsServiceObject.getBookById(itemId)));
        return "item-update";
    }

}















