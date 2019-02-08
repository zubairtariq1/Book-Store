package study.app.bookstore;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import study.app.bookstore.domain.Book;
import study.app.bookstore.domain.BookRepository;
import study.app.bookstore.domain.Category;
import study.app.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository) {
	return (args) -> {
		crepository.save(new Category("Fiction"));
		crepository.save(new Category("Technology"));
		crepository.save(new Category("Comedy"));
		crepository.save(new Category("History"));
		
		repository.save(new Book("The Secret", "Rhonda Byrne", "123321-123", 2002,  50.50, crepository.findByName("Fiction").get(0)));
		repository.save(new Book("Full-Stack Dev", "Juha Hinkula", "123321-123", 2015,  70.50, crepository.findByName("Technology").get(0)));
		repository.save(new Book("Just Laugh", "Rhonda Byrne", "123321-123", 2002,  50.50, crepository.findByName("Comedy").get(0)));
		repository.save(new Book("Full-Stack Dev", "Juha Hinkula", "123321-123", 2015,  70.50, crepository.findByName("Technology").get(0)));
		repository.save(new Book("Thinking Power", "Rhonda Byrne", "123321-123", 2002,  50.50, crepository.findByName("Fiction").get(0)));
		repository.save(new Book("World War 2", "Rhonda Byrne", "123321-123", 2015,  70.50, crepository.findByName("History").get(0)));
			};
			
	
	}

}


