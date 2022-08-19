package com.infy.repository;

import org.springframework.data.repository.CrudRepository;

import com.infy.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

}