package com.example.gk.paymentservice.exception;

public class ResourceNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -5530905773319108137L;

	public ResourceNotFoundException(String message) {
        super(message);
    }
}
