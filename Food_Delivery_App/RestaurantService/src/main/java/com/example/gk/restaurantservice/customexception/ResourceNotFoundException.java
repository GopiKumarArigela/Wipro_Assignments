package com.example.gk.restaurantservice.customexception;

public class ResourceNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -4245122066221902021L;

	public ResourceNotFoundException(String message) {
        super(message);
    }
}