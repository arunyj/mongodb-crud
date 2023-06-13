package com.elixr.mongodbcrud.controller;

import com.elixr.mongodbcrud.model.User;
import com.elixr.mongodbcrud.response.Response;
import com.elixr.mongodbcrud.service.TracingService;
import com.elixr.mongodbcrud.service.UserService;
import com.elixr.mongodbcrud.constants.ResponseStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    TracingService tracingService;

    @Autowired
    UserService userService;

    @Value("${message.success.user.list}")
    private String userListSuccessMessage;

    @Value("${message.success.user.add}")
    private String userAddSuccessMessage;

    @Value("${message.success.user.update}")
    private String userUpdateSuccessMessage;

    @Value("${message.success.user.delete}")
    private String userDeleteSuccessMessage;

    @GetMapping("/list")
    public ResponseEntity<Response> getAllUsers() {
        log.info("User list getting request received");
        List<User> users = userService.getAll();
        log.info(userListSuccessMessage);
        return ResponseEntity.status(HttpStatus.OK).body(new Response(HttpStatus.OK.value(), userListSuccessMessage, ResponseStatus.SUCCESS, tracingService.getTraceId(), users ));
    }

    @PostMapping("/add")
    public ResponseEntity<Response> addUser(@RequestBody User user) {
        log.info("User add request received");
        User savedUser = userService.add(user);
        log.info(userAddSuccessMessage);
        return ResponseEntity.status(HttpStatus.OK).body(new Response(HttpStatus.OK.value(), userAddSuccessMessage, ResponseStatus.SUCCESS, tracingService.getTraceId(), savedUser ));    }

    @PutMapping("/update")
    public ResponseEntity<Response> updateUser(@RequestBody User user) throws Exception {
        log.info("User update request received");
        User updatedUser = userService.update(user);
        log.info(userUpdateSuccessMessage);
        return ResponseEntity.status(HttpStatus.OK).body(new Response(HttpStatus.OK.value(), userUpdateSuccessMessage, ResponseStatus.SUCCESS, tracingService.getTraceId(), updatedUser ));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteUser(@PathVariable String id) throws Exception {
        log.info("User delete request received");
        userService.delete(id);
        log.info(userDeleteSuccessMessage);
        return ResponseEntity.status(HttpStatus.OK).body(new Response(HttpStatus.OK.value(), userDeleteSuccessMessage, ResponseStatus.SUCCESS, tracingService.getTraceId()));
    }
}
