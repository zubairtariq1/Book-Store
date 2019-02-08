package study.app.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import study.app.bookstore.domain.Book;
import study.app.bookstore.domain.BookRepository;
import study.app.bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository;
	@Autowired
	private CategoryRepository crepository;

	@RequestMapping(value="/bookList", method= RequestMethod.GET)
	public String bookList(Model model) {
	model.addAttribute("books", repository.findAll());
	return "bookList";
	}
	
	@RequestMapping(value = "/addBook")
	public String addBook(Model model){
	model.addAttribute("book", new Book());
	model.addAttribute("categories", crepository.findAll());
	return "addBook";
	
	}
	
	@RequestMapping(value = "/editBook/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model){
	model.addAttribute("book", repository.findById(bookId));
	model.addAttribute("categories", crepository.findAll());
	return "editBook";
	}
	
	

	@RequestMapping(value = "/save", method = RequestMethod.POST)
			public String save(Book book){
			repository.save(book);
			return "redirect:bookList";
	
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
	repository.deleteById(bookId);
	return "redirect:../bookList";
	}
	

}
