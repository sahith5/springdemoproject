package com.shop.supermarket.service;



import com.shop.supermarket.entity.Books;

import java.util.List;

public interface bookservice {
    public void saveBook(Books book);

    public List<Books> getbooks();
    public Books getBookById(int id);
    public void deleteById(int id);

}
