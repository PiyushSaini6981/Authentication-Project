package com.JavaMail.JavaMailSender.exceptions;

public class Emailnotsend extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;

	public Emailnotsend() {
		super();
	}

	public Emailnotsend(String message, Throwable cause) {
		super(message, cause);
	}

	public Emailnotsend(String message) {
		super(message);
	}

	public Emailnotsend(Throwable cause) {
		super(cause);
	}
	
	
}
