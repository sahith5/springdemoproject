package com.shop.supermarket.service;



import com.shop.supermarket.entity.Books;
import com.shop.supermarket.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements Bookservice {

    @Autowired
    BooksRepository booksrepository;

    @Override
    public void saveBook(Books book) {
            booksrepository.save(book);
    }

    @Override

    public List<Books> getbooks() {
        return booksrepository.findAll();
    }

    @Override
    public Books getBookById(int id) {
        Optional<Books> book = booksrepository.findById(id);
        Books books;
        if(book.isPresent())
        {
            books=book.get();

        }
        else
        {
            books=null;
        }
        return books;

    }

    @Override
    public void deleteById(int id) {
        booksrepository.deleteById(id);
    }
}
