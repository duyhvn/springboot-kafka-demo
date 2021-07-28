package com.javainuse.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.javainuse.model.Book;
import com.javainuse.repository.BookRepository;

@ExtendWith(SpringExtension.class)
//@SpringBootTest(classes = KafkaApplication.class)
public class BookServiceTest {

	@Mock
	private BookService bookService;

	@Mock
	private ElasticsearchRestTemplate esTemplate;

    @Mock
	private BookRepository bookRepository;

	@BeforeEach
	public void before() {
		esTemplate.delete(Book.class);
		esTemplate.indexOps(Book.class);
//        esTemplate.(Book.class);
//        esTemplate.re(Book.class);
	}

	@Test
	public void testSave() {

		Book book = new Book("1001", "Elasticsearch Basics", "Rambabu Posa", "23-FEB-2017");
		when(bookService.save(book)).thenReturn(book);
		Book testBook = bookService.save(book);

		assertNotNull(testBook.getId());
		assertEquals(testBook.getTitle(), book.getTitle());
		assertEquals(testBook.getAuthor(), book.getAuthor());
		assertEquals(testBook.getReleaseDate(), book.getReleaseDate());

	}

	@Test
	public void testFindOne() {

		Book book = new Book("1001", "Elasticsearch Basics", "Rambabu Posa", "23-FEB-2017");
		when(bookService.findById(book.getId())).thenReturn(book);
		bookService.save(book);

		Book testBook = bookService.findById(book.getId());
		
		// Then
//		verify(bookRepository.findById(book.getId()));

		assertNotNull(testBook.getId());
		assertEquals(testBook.getTitle(), book.getTitle());
		assertEquals(testBook.getAuthor(), book.getAuthor());
		assertEquals(testBook.getReleaseDate(), book.getReleaseDate());

	}

	@Test
	public void testFindByTitle() {

		Book book = new Book("1001", "Elasticsearch Basics", "Rambabu Posa", "23-FEB-2017");
		bookService.save(book);

		Pageable pageable = Pageable.ofSize(10);
		List<Book> byTitle = bookService.findByTitle(book.getTitle(), pageable);
		assertThat(byTitle.size(), is(1));
	}

	@Test
	public void testDelete() {

		Book book = new Book("1001", "Elasticsearch Basics", "Rambabu Posa", "23-FEB-2017");
		bookService.save(book);
		bookService.delete(book.getId());
		Book testBook = bookService.findById(book.getId());
		assertNull(testBook);
	}

}
