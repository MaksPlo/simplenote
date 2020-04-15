package com.spring.simplenote.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{

    private static final String MESSAGE = "object not found";

    public NotFoundException() {
        super(MESSAGE);
    }

    public NotFoundException(Class clazz) {
        super(clazz.getSimpleName() + " " + MESSAGE);
    }

    public NotFoundException(String MESSAGE) { super(MESSAGE); }
}
