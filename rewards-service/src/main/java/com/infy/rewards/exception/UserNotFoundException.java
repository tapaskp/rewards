package com.infy.rewards.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

    public UserNotFoundException() {}

    public UserNotFoundException(String msg) {
        super(msg);
        this.message = msg;
    }
}
