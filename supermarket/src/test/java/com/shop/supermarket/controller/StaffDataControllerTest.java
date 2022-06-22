package com.shop.supermarket.controller;

import com.shop.supermarket.converter.ItemsConverter;

import com.shop.supermarket.entity.Books;

import com.shop.supermarket.repository.BooksRepository;

import com.shop.supermarket.service.Bookservice;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@SpringBootTest
public class StaffDataControllerTest {
    private MockMvc mockMvc;



    @Autowired
    ItemsConverter itemsConverter;

    @MockBean
    BooksRepository itemsRepository;

    @Autowired
    Bookservice itemsService;

    @Autowired
    private WebApplicationContext wac;








    @Test
    void stockListTesting() throws Exception {


               when(itemsRepository.findAll()).thenReturn(Stream.of(new Books(1,"Sahith",200),new Books(2,"hello",300) ).collect(Collectors.toList()));

        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        mockMvc.perform(get("/staff/stockList")).andExpect(status().is(200));
            System.out.println(itemsService.getbooks());



        }


    @Test
    void saveItem() throws Exception
    {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        mockMvc.perform(get("/staff/saveItem")).andExpect(status().is(405));
    }
    @Test
    void  deleteTest() throws Exception
    {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        mockMvc.perform(get("/staff/deleteItem").queryParam("id","1")).andExpect(status().is(405));
    }

    @Test
    void  updateTest() throws Exception
    {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        mockMvc.perform(get("/staff/updateItem").queryParam("id","1")).andExpect(status().is(405));
    }




}
