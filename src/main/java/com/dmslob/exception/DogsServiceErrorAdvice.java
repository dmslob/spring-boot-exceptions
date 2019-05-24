package com.dmslob.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.SQLException;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

// Spring 3.2
@ControllerAdvice
public class DogsServiceErrorAdvice {

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<String> handleRunTimeException(RuntimeException e) {
        return error(INTERNAL_SERVER_ERROR, e);
    }

    //@ExceptionHandler({DogsNotFoundException.class})
    public ResponseEntity<String> handleNotFoundException(DogsNotFoundException e) {
        return error(NOT_FOUND, e);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({DogsNotFoundException.class})
    public void handle(DogsNotFoundException e) {
        System.out.println("NOT_FOUND");
    }

    //@ExceptionHandler({DogsServiceException.class})
    public ResponseEntity<String> handleDogsServiceException(DogsServiceException e) {
        return error(INTERNAL_SERVER_ERROR, e);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({DogsServiceException.class, SQLException.class, NullPointerException.class})
    public void handle() {
        System.out.println("INTERNAL_SERVER_ERROR");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({DogsServiceValidationException.class})
    public void handle(DogsServiceValidationException e) {
        System.out.println("BAD_REQUEST");
    }

    private ResponseEntity<String> error(HttpStatus status, Throwable e) {
        return ResponseEntity.status(status).body(e.getMessage());
    }
}
