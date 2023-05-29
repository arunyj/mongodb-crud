package com.elixr.mongodbcrud.service;

import com.elixr.mongodbcrud.exception.UserNotFoundException;
import com.elixr.mongodbcrud.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAll();

    Optional<User> getById(String id);

    User add(User user);

    void delete(String id) throws UserNotFoundException;

    User update(User user) throws UserNotFoundException;
}
