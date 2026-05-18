package com.example.mural.repositories;

import java.util.Optional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

	private final IUserDAO userDAO;
	private final PasswordEncoder passwordEncoder;

	public UserRepository(IUserDAO userDAO, PasswordEncoder passwordEncoder) {
		this.userDAO = userDAO;
		this.passwordEncoder = passwordEncoder;
	}

	public Optional<User> findByUsername(String username) {
		return userDAO.findByUsername(username);
	}

	public long count() {
		return userDAO.count();
	}

	public void save(String username, String password, String role) {
		var user = new User();
		user.setUsername(username);
		user.setPassword(passwordEncoder.encode(password));
		user.setRole(role);
		userDAO.save(user);
	}
}
