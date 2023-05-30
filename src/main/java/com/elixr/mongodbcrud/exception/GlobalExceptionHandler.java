package com.elixr.mongodbcrud.exception;

import com.elixr.mongodbcrud.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> handleException(Exception exc) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("Error occurred! " + exc.getMessage()));
    }
}
