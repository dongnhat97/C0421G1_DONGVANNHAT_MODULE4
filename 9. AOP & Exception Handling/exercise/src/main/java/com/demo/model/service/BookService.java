package com.demo.model.service;

import com.demo.model.bean.Book;
import com.demo.model.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService implements IBookService{
    @Autowired
    IBookRepository iBookRepository;
    @Override
    public List<Book> finAll() {
        return iBookRepository.findAll();
    }

    @Override
    public void save(Book book) {
       iBookRepository.save(book);
    }

    @Override
    public Book findById(int id) {
        return iBookRepository.findById(id).get();
    }
}
