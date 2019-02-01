package study.app.bookstore;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import study.app.bookstore.domain.Book;
import study.app.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
	return (args) -> {
		repository.save(new Book("The Secret", "Rhonda Byrne", "123321-123", 2002,  50.50));
		repository.save(new Book("Full-Stack Dev", "Juha Hinkula", "123321-123", 2015,  70.50));
		repository.save(new Book("The Secret", "Rhonda Byrne", "123321-123", 2002,  50.50));
		repository.save(new Book("Full-Stack Dev", "Juha Hinkula", "123321-123", 2015,  70.50));
		repository.save(new Book("The Secret", "Rhonda Byrne", "123321-123", 2002,  50.50));
		repository.save(new Book("Full-Stack Dev", "Juha Hinkula", "123321-123", 2015,  70.50));
			
		};
	}

}


