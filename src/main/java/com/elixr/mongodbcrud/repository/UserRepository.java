package com.elixr.mongodbcrud.repository;

import com.elixr.mongodbcrud.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
