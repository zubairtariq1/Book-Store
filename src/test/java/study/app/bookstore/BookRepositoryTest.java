package study.app.bookstore;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import study.app.bookstore.domain.BookRepository;
import study.app.bookstore.domain.Category;
import study.app.bookstore.domain.CategoryRepository;
import study.app.bookstore.domain.UserRepository;
import study.app.bookstore.domain.User;
import study.app.bookstore.domain.Book;


@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {
	

	@Autowired
	private BookRepository brepository;
	
	@Autowired
	private UserRepository urepository;
	
	@Autowired
	private CategoryRepository crepository;
	
	
	
	
	
	
	@Test
	 public void findByTitleShouldReturnBook() {
        List<Book> books = brepository.findByTitle("The Secret");
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("Rhonda Byrne");
    }
	
	@Test 
	public void addBook() {
    	Book testBook = new Book("Test", "TestAuthor", "123-321", 2019, 50.50, new Category("Test"));
    	brepository.save(testBook);
    	assertThat(testBook.getId()).isNotNull();
    }
	
	@Test
    public void deleteBook() {
        List<Book> books = brepository.findByTitle("The Secret");
        assertThat(books).hasSize(1);
    	brepository.deleteById(books.get(0).getId());
    	List<Book> deletedBooks = brepository.findByTitle("The Secret");
    	assertThat(deletedBooks).hasSize(0);
    }
	
	@Test
	public void findByUsernameShouldReturnUser() {
		User testUser = urepository.findByUsername("admin");
		 assertThat(testUser.getRole()).isEqualTo("ADMIN");
		
	}
	
	@Test
	public void newUser() {
		User testUser = new User("test", "testPassword", "testRole");
		urepository.save(testUser);
		assertThat(testUser.getId()).isNotNull();
	}
	
	@Test
	public void deleteUser() {
		 List<User> users = urepository.findByRole("USER");
	        assertThat(users).hasSize(1);
	    	urepository.deleteById(users.get(0).getId());
	        List<User> deletedUsers = urepository.findByRole("USER");
	    	assertThat(deletedUsers).hasSize(0); 
	}
	
	@Test
	public void findbyNameShouldReturnName() {
		 List<Category> categories = crepository.findByName("Fiction");
		 assertThat(categories).hasSize(1);
		 assertThat(categories.get(0).getName()).isEqualTo("Fiction");
    }
	
	@Test
	public void insertCategory() {
		Category testCategory = new Category("testCategory");
		crepository.save(testCategory);
		assertThat(testCategory.getCategoryid()).isNotNull();
	}
	
	@Test
	public void deleteCategory() {
		List<Category> categories = crepository.findByName("Fiction");
		assertThat(categories).hasSize(1);
		crepository.deleteById(categories.get(0).getCategoryid());
		List<Category> deletedCategories = crepository.findByName("Fiction");
		assertThat(deletedCategories).hasSize(0);
		
	}
	
		
	}
	
	


