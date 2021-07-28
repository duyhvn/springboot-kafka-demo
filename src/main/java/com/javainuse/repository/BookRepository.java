package com.javainuse.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.javainuse.model.Book;

import java.util.List;

public interface BookRepository /* extends ElasticsearchRepository<Book, String> */{

    Page<Book> findByAuthor(String author, Pageable pageable);

    List<Book> findByTitle(String title, Pageable pageable);

}
