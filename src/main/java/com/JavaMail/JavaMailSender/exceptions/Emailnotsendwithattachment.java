package com.JavaMail.JavaMailSender.exceptions;

public class Emailnotsendwithattachment extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String message;

	public Emailnotsendwithattachment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emailnotsendwithattachment(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public Emailnotsendwithattachment(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public Emailnotsendwithattachment(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
