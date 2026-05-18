package com.example.mural.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IMessageDAO extends CrudRepository<Message, Long> {

	@Override
	Message save(Message message);

	@Override
	List<Message> findAll();

	@Query("SELECT m FROM Message m ORDER BY m.id DESC")
	List<Message> findAllOrderedByIdDesc();
}
