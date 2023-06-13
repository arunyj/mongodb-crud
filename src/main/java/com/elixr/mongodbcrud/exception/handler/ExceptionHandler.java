package com.elixr.mongodbcrud.exception.handler;

import com.elixr.mongodbcrud.constants.ResponseStatus;
import com.elixr.mongodbcrud.response.Response;
import com.elixr.mongodbcrud.service.TracingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @Autowired
    TracingService tracingService;

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<Response> handleException(Exception exc) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(HttpStatus.BAD_REQUEST.value(), exc.getMessage(), ResponseStatus.FAILURE, tracingService.getTraceId()));
    }
}
