package com.elixr.mongodbcrud.exception.handler;

import com.elixr.mongodbcrud.constants.ResponseStatus;
import com.elixr.mongodbcrud.exception.InvalidInputException;
import com.elixr.mongodbcrud.exception.UserNotFoundException;
import com.elixr.mongodbcrud.response.Response;
import com.elixr.mongodbcrud.service.TracingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    TracingService tracingService;

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<Response> handleInvalidInputException(InvalidInputException exc) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(HttpStatus.BAD_REQUEST.value(), exc.getMessage(), ResponseStatus.FAILURE, tracingService.getTraceId()));
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Response> handleUserNotFoundException(UserNotFoundException exc) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response(HttpStatus.NOT_FOUND.value(), exc.getMessage(), ResponseStatus.FAILURE, tracingService.getTraceId()));
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<Response> handleException(Exception exc) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(HttpStatus.BAD_REQUEST.value(), exc.getMessage(), ResponseStatus.FAILURE, tracingService.getTraceId()));
    }
}
