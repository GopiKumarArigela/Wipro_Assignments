package com.example.gk.restaurantservice.customexception;

public class BadRequestException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -8856045001986685470L;

	public BadRequestException(String message) {
        super(message);
    }
}
