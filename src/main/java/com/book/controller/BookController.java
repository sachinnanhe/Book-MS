package com.book.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.book.entity.Book;
import com.book.service.BookService;



@RestController
@CrossOrigin(origins="http://localhost:4200")
public class BookController {
	
	@Autowired
	private BookService bookservice;
	
	@PostMapping("/book")
	Book saveBook(@RequestBody Book book) {
		Book saveBook = bookservice.saveBook(book);
		return saveBook;
	}
	@GetMapping("/allbook")
	public List<Book> getAllBooks(){
		return bookservice.getAllBooks();
	}
	@GetMapping("/book/{id}")
	public Optional<Book> getbook(@PathVariable Integer id){
		Optional<Book> book = bookservice.getBook(id);
		return book;
	}
	@DeleteMapping("/book/{id}")
	public ResponseEntity<Book> deleteBook(@PathVariable Integer id){
		System.out.println(id);
		ResponseEntity<Book> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		try {
	          bookservice.deleteBook(id);
		}
		catch(Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	
	@DeleteMapping("/allbook")
	public void deleteAllBook() {
		bookservice.deleteAllBook();
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable("id") Integer id, @RequestBody Book book){
		return new ResponseEntity<Book>(bookservice.updateBook(book, id),HttpStatus.OK);
	}
	
}

