package com.example.mural.dto;

import jakarta.validation.constraints.NotBlank;

public class SendMessageForm {

	@NotBlank(message = "{sendMessageForm.from.notBlank}")
	private String from;

	@NotBlank(message = "{sendMessageForm.to.notBlank}")
	private String to;

	@NotBlank(message = "{sendMessageForm.message.notBlank}")
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
