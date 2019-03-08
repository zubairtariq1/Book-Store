package study.app.bookstore.domain;

import java.util.List;

import study.app.bookstore.domain.User;


import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String Username);
	List<User> findByRole(String role);
}