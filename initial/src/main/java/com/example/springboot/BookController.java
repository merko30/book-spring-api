package com.example.springboot;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.dto.CreateBookDto;
import com.example.springboot.entity.Book;
import com.example.springboot.mapper.BookMapper;
import com.example.springboot.repository.BookRepository;

import jakarta.validation.Valid;

@RestController
public class BookController {

	private final BookRepository bookRepository;

	public BookController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@PostMapping("/books")
	public Book createBook(@Valid @RequestBody CreateBookDto bookInput) {
		Book book = BookMapper.toEntity(bookInput);
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
	public Book updateBook(@PathVariable Long id, Book book){
		return bookRepository.findById(id)
				.map(existingBook -> {
					existingBook.setTitle(book.getTitle());
					existingBook.setAuthor(book.getAuthor());
					return bookRepository.save(existingBook);
				})
				.orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
	}

	@DeleteMapping("/books/{id}")
	public void deleteBook(@PathVariable Long id) {
		bookRepository.deleteById(id);
	}



}
