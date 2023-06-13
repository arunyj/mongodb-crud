package com.elixr.mongodbcrud.service.impl;

import com.elixr.mongodbcrud.exception.UserNotFoundException;
import com.elixr.mongodbcrud.model.User;
import com.elixr.mongodbcrud.repository.UserRepository;
import com.elixr.mongodbcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService  {

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
        Optional<User> user = this.getById(id);
        if(user.isPresent()) {
            userRepository.deleteById(user.get().getId());
        } else {
            throw new UserNotFoundException();
        }
    }

    @Override
    public User update(User user) throws UserNotFoundException {
        Optional<User> userCheck = this.getById(user.getId());
        if(userCheck.isEmpty()) {
            throw new UserNotFoundException();
        } else {
           user = userRepository.save(user);
        }
        return user;
    }
}
