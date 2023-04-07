package com.training.spring6.services;

import com.training.spring6.domain.Book;

public interface BookService {

    Iterable<Book> findAll();
}
