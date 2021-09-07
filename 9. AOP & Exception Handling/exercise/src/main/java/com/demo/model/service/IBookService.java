package com.demo.model.service;

import com.demo.model.bean.Book;

import java.util.List;

public interface IBookService {
    List<Book> finAll();
    void save(Book book);
    Book findById(int id);
}
