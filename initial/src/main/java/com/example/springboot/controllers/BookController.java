package com.example.springboot.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.dto.CreateBookDto;
import com.example.springboot.dto.UpdateBookDto;
import com.example.springboot.entity.Book;
import com.example.springboot.mapper.BookMapper;
import com.example.springboot.repository.BookRepository;

import jakarta.validation.Valid;

@RestController
public class BookController {

	private final BookRepository bookRepository;
	private final BookMapper bookMapper;

	public BookController(BookRepository bookRepository,
			BookMapper bookMapper) {
		this.bookRepository = bookRepository;
		this.bookMapper = bookMapper;
	}

	@PostMapping("/books")
	public Book createBook(@Valid @RequestBody CreateBookDto bookInput) {
		Book book = bookMapper.toEntity(bookInput);
		return bookRepository.save(book);
	}

	@GetMapping("/books")
	public List<Book> index() {
		return bookRepository.findAll();
	}

	@GetMapping("/books/{id}")
	public Book details(@PathVariable Long id) {
		return bookRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
	}

	@PutMapping("/books/{id}")
	public Book updateBook(@PathVariable Long id, @Valid @RequestBody UpdateBookDto bookDto){
		return bookRepository.findById(id)
				.map(existingBook -> {
					bookMapper.updateBookFromDto(bookDto, existingBook);
					return bookRepository.save(existingBook);
				})
				.orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
	}

	@DeleteMapping("/books/{id}")
	public void deleteBook(@PathVariable Long id) {
		bookRepository.deleteById(id);
	}



}
