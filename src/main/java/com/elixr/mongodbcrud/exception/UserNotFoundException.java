package com.elixr.mongodbcrud.exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
        super("Requested user not found. Please check the user ID!");
    }
}
