package com.kaushik.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST) // Optional: Maps this exception to HTTP 400
public class UserException extends RuntimeException {

    public UserException(String message) {
        super(message);
    }
}
