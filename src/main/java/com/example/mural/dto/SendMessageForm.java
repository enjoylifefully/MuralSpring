package com.example.mural.dto;

import jakarta.validation.constraints.NotBlank;

public class SendMessageForm {

	@NotBlank(message = "o campo enviado por é obrigatório")
	private String from;

	@NotBlank(message = "o campo enviado para é obrigatório")
	private String to;

	@NotBlank(message = "o campo mensagem é obrigatório")
	private String message;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return String.format("SendMessageForm[from='%s', to='%s', message='%s']", from, to, message);
	}
}
