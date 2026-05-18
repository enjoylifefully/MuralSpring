package com.example.mural.repositories;

import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class MessageRepository {

	private static final Logger logger = LoggerFactory.getLogger(MessageRepository.class);

	private final IMessageDAO messageDAO;

	public MessageRepository(IMessageDAO messageDAO) {
		this.messageDAO = messageDAO;
		logger.info("MessageRepository instantiated");
	}

	public void save(Message message) {
		message.setTimestamp(new Date().toString());
		var saved = messageDAO.save(message);
		logger.info("saving message: {}", saved);
	}

	public List<Message> getMessages() {
		return messageDAO.findAllOrderedByIdDesc();
	}
}
