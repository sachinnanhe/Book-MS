package com.book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.entity.Book;
import com.book.exception.ResourceNotFoundException;



@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookRepository bookrepository;

	@Override
	public Book saveBook(Book book) {
		Book savedBook = bookrepository.save(book);
		return savedBook;
	}

	@Override
	public List<Book> getAllBooks() {
		return bookrepository.findAll();
	}

	@Override
	public Optional<Book> getBook(Integer id) {
		return bookrepository.findById(id);
	}

	@Override
	public void deleteBook(Integer id) {
		bookrepository.deleteById(id);
	}

	@Override
	public void deleteAllBook() {
         bookrepository.deleteAll();
		
	}

	@Override
	public Book updateBook(Book book, Integer id) {
		
		Book existingBook = bookrepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Book","id",id));
		existingBook.setTitle(book.getTitle());
		existingBook.setAuthor(book.getAuthor());
		existingBook.setCategory(book.getCategory());
		existingBook.setImage(book.getImage());
		existingBook.setPrice(book.getPrice());
		existingBook.setPublisher(book.getPublisher());
		existingBook.setActive(book.isActive());
		
		bookrepository.save(existingBook);
		return existingBook;
	}
	
}
