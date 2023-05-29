package com.elixr.mongodbcrud.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Data
@Document("users")
public class User {
    @Id
    String id;
    String name;
    int age;
    String sex;
}
