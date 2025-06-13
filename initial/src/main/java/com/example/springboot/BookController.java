package com.example.springboot;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.Book;
import com.example.springboot.repository.BookRepository;

@RestController
public class BookController {

	private final BookRepository bookRepository;

	public BookController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@GetMapping("/")
	public List<Book> index() {
		return bookRepository.findAll();
	}

}
