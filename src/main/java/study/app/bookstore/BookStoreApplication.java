package study.app.bookstore;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import study.app.bookstore.domain.Book;
import study.app.bookstore.domain.BookRepository;
import study.app.bookstore.domain.Category;
import study.app.bookstore.domain.CategoryRepository;
import study.app.bookstore.domain.User;
import study.app.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository, UserRepository urepository) {
	return (args) -> {
		
		//Creating Users
				User user1 = new User("user", "$2a$06$tZRldrGykGefDrX3vBs5feouwcXuOkNvIV46.yE6DQP37nK1IQNDi", "USER");
				User user2 = new User("admin", "$2a$10$62D3NJlHNxqX/t4.OMVmheAp7XRTNSxeu1Ql8QA/cjzEgCeHac5AG", "ADMIN");
				urepository.save(user1);
				urepository.save(user2);
		
		//Creating Some Categories
		crepository.save(new Category("Fiction"));
		crepository.save(new Category("Technology"));
		crepository.save(new Category("Comedy"));
		crepository.save(new Category("History"));
		
		//Creating some Books
		repository.save(new Book("The Secret", "Rhonda Byrne", "123321-123", 2002,  50.50, crepository.findByName("Fiction").get(0)));
		repository.save(new Book("Full-Stack Dev", "Juha Hinkula", "123321-123", 2015,  70.50, crepository.findByName("Technology").get(0)));
		repository.save(new Book("Just Laugh", "Rhonda Byrne", "123321-123", 2002,  50.50, crepository.findByName("Comedy").get(0)));
		repository.save(new Book("Full-Stack Dev", "Juha Hinkula", "123321-123", 2015,  70.50, crepository.findByName("Technology").get(0)));
		repository.save(new Book("Thinking Power", "Rhonda Byrne", "123321-123", 2002,  50.50, crepository.findByName("Fiction").get(0)));
		repository.save(new Book("World War 2", "Rhonda Byrne", "123321-123", 2015,  70.50, crepository.findByName("History").get(0)));
		
		
		};
			
	
	}

}


