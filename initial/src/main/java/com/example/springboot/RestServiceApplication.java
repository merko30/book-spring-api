package com.example.springboot;

// import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.Bean;

// import com.example.springboot.entity.Book;
// import com.example.springboot.repository.BookRepository;

@SpringBootApplication
public class RestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestServiceApplication.class, args);
	}

	// @Bean
	// public CommandLineRunner seed(BookRepository bookRepository) {
	// 	return args -> {
	// 		if(bookRepository.count() > 0) {
	// 			return; // Skip seeding if there are already books
	// 		}
	// 		bookRepository.save(new Book("The Great Gatsby", "F. Scott Fitzgerald"));
	// 		bookRepository.save(new Book("To Kill a Mockingbird", "Harper Lee"));
	// 		bookRepository.save(new Book("1984", "George Orwell"));
	// 		bookRepository.save(new Book("Pride and Prejudice", "Jane Austen"));
	// 		bookRepository.save(new Book("The Catcher in the Rye", "J.D. Salinger"));
	// 	};
	// }

	
}
