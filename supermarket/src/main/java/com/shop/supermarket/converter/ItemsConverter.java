package com.shop.supermarket.converter;

import com.shop.supermarket.dto.Booksdto;
import com.shop.supermarket.entity.Books;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemsConverter {
    @Autowired
    private ModelMapper modelMapper;

    public Booksdto entityToDto(Books items)
    {
        return modelMapper.map(items,Booksdto.class);
    }

    public List<Booksdto> entityToDto(List<Books> items)
    {
        return items.stream().map(this::entityToDto).collect(Collectors.toList());
    }


    public Books dtoToEntity(Booksdto itemsDTO)
    {
        return modelMapper.map(itemsDTO,Books.class);
    }


}
