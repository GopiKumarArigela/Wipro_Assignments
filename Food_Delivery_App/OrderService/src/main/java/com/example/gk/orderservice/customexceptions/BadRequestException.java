package com.example.gk.orderservice.customexceptions;

public class BadRequestException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -688912940955677324L;

	public BadRequestException(String message) { super(message); }
}
