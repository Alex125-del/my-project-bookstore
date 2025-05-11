package com.manager.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class AuthorNotFoundException extends ResponseStatusException {
    public AuthorNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND,message);
    }
}
