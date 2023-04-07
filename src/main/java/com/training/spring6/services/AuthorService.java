package com.training.spring6.services;

import com.training.spring6.domain.Author;

public interface AuthorService {

    Iterable<Author> findAll();
}
