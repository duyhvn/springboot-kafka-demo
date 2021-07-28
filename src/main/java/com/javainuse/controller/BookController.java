package com.javainuse.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.model.Book;
import com.javainuse.service.BookService;

//@RestController
public class BookController {

//	@Autowired
	private BookService bookService;

	@GetMapping("/books/{bookId}")
	public Book getBookBybookId(@PathVariable String bookId) {
		return bookService.findById(bookId);
	}

	@GetMapping("/books/book")
	public List<Book> getByTitle(@RequestParam("title") String title, Pageable pageable) {
		return bookService.findByTitle(title, pageable);
	}

	@GetMapping("/books")
	public Set<Book> getQuestions(Pageable pageable) {
		Set<Book> result = new HashSet<Book>();
		bookService.findAll(pageable).forEach(result::add);
		return result;
	}

	@PostMapping("/books")
	public Book createQuestion(@Valid @RequestBody Book employee) {
		long i = 0;
		/*
		 * while(i < 10L) { i++; bookService.save(employee); }
		 */
		return bookService.save(employee);
	}

	@DeleteMapping("/books/{bookId}")
	public void deleteBook(@PathVariable String bookId) {
		bookService.delete(bookId);
	}
}
