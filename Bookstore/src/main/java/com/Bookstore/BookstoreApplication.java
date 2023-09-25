package com.Bookstore;

import com.Bookstore.domain.Book;
import com.Bookstore.domain.BookRepository;
import com.Bookstore.domain.Category;
import com.Bookstore.domain.CategoryRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {
			
			categoryRepository.save(new Category("Fiction"));
	        categoryRepository.save(new Category("Non-Fiction"));

			log.info("saved a couple of books");
			
			bookRepository.save(new Book("1984", "George Orwell", 1984, "ISBN1", 10.5, categoryRepository.findByName("Fiction").get(0)));
			bookRepository.save(new Book("Life 3.0", "Max Tegmark", 2000, "ISBN1", 10.5, categoryRepository.findByName("Non-Fiction").get(0)));

		};
	}

}
