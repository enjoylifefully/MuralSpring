package com.example.mural.repositories;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface IUserDAO extends CrudRepository<User, Long> {

	Optional<User> findByUsername(String username);
}
