package com.shop.supermarket.service;



import com.shop.supermarket.entity.Books;
import com.shop.supermarket.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements bookservice{

    @Autowired
    BooksRepository booksrepository;

    @Override
    @Transactional
    public void saveBook(Books book) {

            booksrepository.save(book);
    }

    @Override
    @Transactional
    public List<Books> getbooks() {
        return booksrepository.findAll();
    }

    @Override
    @Transactional
    public Books getBookById(int id) {
        return booksrepository.findById(id).get();
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        booksrepository.deleteById(id);
    }
}
