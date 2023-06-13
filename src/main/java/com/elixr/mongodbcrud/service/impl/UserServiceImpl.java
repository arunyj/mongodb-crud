package com.elixr.mongodbcrud.service.impl;

import com.elixr.mongodbcrud.exception.UserNotFoundException;
import com.elixr.mongodbcrud.model.User;
import com.elixr.mongodbcrud.repository.UserRepository;
import com.elixr.mongodbcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService  {

    @Value("${message.error.user.not.found}")
    private String ERROR_MESSAGE_USE_NOT_FOUND;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(String id) throws UserNotFoundException {
        User user = this.getById(id).orElseThrow(()-> new UserNotFoundException(ERROR_MESSAGE_USE_NOT_FOUND));
        userRepository.deleteById(user.getId());
    }

    @Override
    public User update(User user) throws UserNotFoundException {
        this.getById(user.getId()).orElseThrow(() ->new UserNotFoundException(ERROR_MESSAGE_USE_NOT_FOUND));
        return userRepository.save(user);
    }
}
