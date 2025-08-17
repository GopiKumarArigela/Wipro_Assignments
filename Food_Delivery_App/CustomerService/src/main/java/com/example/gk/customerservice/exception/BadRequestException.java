package com.example.gk.customerservice.exception;

public class BadRequestException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4681555715837545784L;

	public BadRequestException(String message) {
        super(message);
    }
}