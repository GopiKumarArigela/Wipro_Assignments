package com.example.gk.orderservice.customexceptions;



public class ResourceNotFoundException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4515388886857639193L;

	public ResourceNotFoundException(String message) {
        super(message);
    }
}
