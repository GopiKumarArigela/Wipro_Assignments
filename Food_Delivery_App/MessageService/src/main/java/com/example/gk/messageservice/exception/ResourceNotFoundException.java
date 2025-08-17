package com.example.gk.messageservice.exception;

public class ResourceNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 6565097615771570198L;

	public ResourceNotFoundException(String message) {
        super(message);
    }
}
