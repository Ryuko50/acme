package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.example.model.User;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.net.URI;


@RestController
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private final UserService userService;


    @SneakyThrows
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable(value="id") Long id){
        return ResponseEntity.ok(userService.getUser(id));
    }

    @SneakyThrows
    @PostMapping("/user")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        userService.saveOrUpdate(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @SneakyThrows
    @PutMapping("/user")
    public ResponseEntity<Void> updateUser(@RequestBody User user){
        userService.saveOrUpdate(user);
        return ResponseEntity.noContent().build();
    }

}
