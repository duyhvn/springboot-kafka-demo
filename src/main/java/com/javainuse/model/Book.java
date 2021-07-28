package com.javainuse.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Getter;
import lombok.Setter;

@Document(indexName = "brycenvn")
//@Document(indexName = "blog", type = "article")
@Getter
@Setter
public class Book {

	@Id
	private String id;
	private String title;
	private String author;
	private String releaseDate;

	public Book() {
	}

	public Book(String id, String title, String author, String releaseDate) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.releaseDate = releaseDate;
	}

	// getters and setters

	@Override
	public String toString() {
		return "Book{" + "id='" + id + '\'' + ", title='" + title + '\'' + ", author='" + author + '\''
				+ ", releaseDate='" + releaseDate + '\'' + '}';
	}
}
