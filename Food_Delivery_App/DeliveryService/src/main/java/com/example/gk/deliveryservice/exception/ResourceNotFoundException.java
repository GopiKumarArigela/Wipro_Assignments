package com.example.gk.deliveryservice.exception;

public class ResourceNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 8130557375254207187L;

	public ResourceNotFoundException(String message) {
        super(message);
    }
}
