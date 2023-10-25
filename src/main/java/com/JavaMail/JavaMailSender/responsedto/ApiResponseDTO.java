package com.JavaMail.JavaMailSender.responsedto;

public class ApiResponseDTO {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public ApiResponseDTO(String message) {
		super();
		this.message = message;
	}
}
