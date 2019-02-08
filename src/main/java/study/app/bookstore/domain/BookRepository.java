package study.app.bookstore.domain;

import org.springframework.data.repository.CrudRepository;
public interface BookRepository extends CrudRepository<Book, Long> {
	
}
