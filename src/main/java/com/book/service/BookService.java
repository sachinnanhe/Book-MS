package com.book.service;

import java.util.List;
import java.util.Optional;

import com.book.entity.Book;


public interface BookService {
	
	Book saveBook(Book book);
	
	List<Book> getAllBooks();
	
	Optional<Book> getBook(Integer id);
	
	public void deleteBook(Integer id);
	
	public void deleteAllBook();
	
	Book updateBook(Book book , Integer id);
}

