package com.ayachama.movieflix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class UserNameAndPasswordNoMatchException extends RuntimeException {
	
	private static final long serialVersionUID = 3L;

	public UserNameAndPasswordNoMatchException(String message) {
		super(message);
	}
	
}
