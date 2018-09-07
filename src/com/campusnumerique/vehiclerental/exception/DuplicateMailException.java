package com.campusnumerique.vehiclerental.exception;

public class DuplicateMailException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateMailException() {
		
	}

	public DuplicateMailException(String message) {
		super(message);
		
	}

	public DuplicateMailException(Throwable cause) {
		super(cause);
		
	}

	public DuplicateMailException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public DuplicateMailException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
