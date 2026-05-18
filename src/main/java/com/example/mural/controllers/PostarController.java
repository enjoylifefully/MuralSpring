package com.example.mural.controllers;

import com.example.mural.dto.SendMessageForm;
import com.example.mural.repositories.Message;
import com.example.mural.repositories.MessageRepository;
import jakarta.validation.Valid;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PostarController {

	private static final Logger logger = LoggerFactory.getLogger(PostarController.class);

	private final MessageRepository messageRepository;
	private final MessageSource messageSource;

	public PostarController(MessageRepository messageRepository, MessageSource messageSource) {
		this.messageRepository = messageRepository;
		this.messageSource = messageSource;
	}

	@GetMapping("/postar")
	public String get(Model model) {
		logger.info("get /postar");
		model.addAttribute("sendMessageForm", new SendMessageForm());
		return "postar";
	}

	@PostMapping("/postar")
	public String post(@Valid @ModelAttribute SendMessageForm sendMessageForm,
			BindingResult bindingResult,
			RedirectAttributes redirectAttributes,
			Locale locale) {
		logger.info("post /postar - {}", sendMessageForm);

		var from = sendMessageForm.getFrom();
		var to = sendMessageForm.getTo();
		if (from != null && to != null && !from.isBlank() && from.equals(to)) {
			logger.info("from and to are the same");
			bindingResult.reject("from.to.same");
		}

		if (bindingResult.hasErrors()) {
			return "postar";
		}

		var message = new Message();
		message.setFrom(sendMessageForm.getFrom());
		message.setTo(sendMessageForm.getTo());
		message.setMessage(sendMessageForm.getMessage());
		messageRepository.save(message);

		redirectAttributes.addFlashAttribute("success",
				messageSource.getMessage("message.sent.success", null, locale));
		return "redirect:/mensagens";
	}
}
