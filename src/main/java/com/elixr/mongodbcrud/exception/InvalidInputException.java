package com.elixr.mongodbcrud.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class InvalidInputException extends Exception {
    private String message;
}
