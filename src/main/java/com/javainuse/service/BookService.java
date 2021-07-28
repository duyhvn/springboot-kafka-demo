package com.javainuse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.javainuse.exception.ResourceNotFoundException;
import com.javainuse.model.Book;
import com.javainuse.repository.BookRepository;

@Service
public class BookService {

	private BookRepository bookRepository;

//	@Autowired
	public void setBookRepository(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public Book save(Book book) {
//		return bookRepository.save(book);
		return null;
	}

	public void delete(String id) {
		/*
		 * Optional.of(findById(id)).map((book) -> {bookRepository.delete(book); return
		 * book; } ) .orElseThrow(() -> new
		 * ResourceNotFoundException("Book not found with id" + id));
		 */
	}

	public Book findById(String id) {
		return null;
//		return bookRepository.findById(id).get();
	}

	public Iterable<Book> findAll(Pageable pageable) {
		return null;
//		return bookRepository.findAll(pageable);
	}

	public Page<Book> findByAuthor(String author, PageRequest pageRequest) {
		return bookRepository.findByAuthor(author, pageRequest);
	}

	public List<Book> findByTitle(String title, Pageable pageable) {
		return bookRepository.findByTitle(title, pageable);
	}

}