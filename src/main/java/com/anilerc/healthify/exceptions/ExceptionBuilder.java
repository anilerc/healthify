package com.anilerc.healthify.exceptions;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ExceptionBuilder {


    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException e) {
        ApiException apiException = new ApiException(e.getMessage(), HttpStatus.NOT_FOUND, ZonedDateTime.now());

        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidArgumentsException(MethodArgumentNotValidException e) {
        ApiException apiException = new ApiException(e.getMessage(), HttpStatus.BAD_REQUEST, ZonedDateTime.now());

        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }
}
