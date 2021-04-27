package com.springboot.demo.es;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Package org.jon.lv.es.BookServiceImpl
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/5/22 13:57
 * version V1.0.0
 */
@Service
public class    BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }
    @Override
    public void delete(Book book) {
        bookRepository.delete(book);
    }
    @Override
    public Book findOne(String id) {
        return null;
    }
    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
    @Override
    public Page<Book> findByAuthor(String author, PageRequest pageRequest) {
        return bookRepository.findByAuthor(author, pageRequest);
    }
    @Override
    public List<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }
}
