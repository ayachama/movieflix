package com.ayachama.movieflix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class MovieDetailsNotFound extends RuntimeException {
	
	private static final long serialVersionUID = 4L;

	public MovieDetailsNotFound(String message) {
		super(message);
	}
	
}
