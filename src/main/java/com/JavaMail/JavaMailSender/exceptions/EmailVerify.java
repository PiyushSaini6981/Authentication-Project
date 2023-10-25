package com.JavaMail.JavaMailSender.exceptions;

public class EmailVerify extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;

	public EmailVerify() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmailVerify(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public EmailVerify(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public EmailVerify(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
