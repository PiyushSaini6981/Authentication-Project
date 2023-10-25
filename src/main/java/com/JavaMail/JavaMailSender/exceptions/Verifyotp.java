package com.JavaMail.JavaMailSender.exceptions;

public class Verifyotp extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;

	public Verifyotp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Verifyotp(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public Verifyotp(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public Verifyotp(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
