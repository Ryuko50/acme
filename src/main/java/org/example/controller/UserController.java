package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.example.dto.UserDto;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private final UserService userService;


    @SneakyThrows
    @GetMapping("/user/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable(value="id") Long id){
        return ResponseEntity.ok(userService.getUser(id));
    }

    @SneakyThrows
    @PostMapping("/user")
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto user){
        userService.saveOrUpdate(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @SneakyThrows
    @PutMapping("/user")
    public ResponseEntity<Void> updateUser(@RequestBody UserDto user) {
        userService.saveOrUpdate(user);
        return ResponseEntity.noContent().build();
    }

    @SneakyThrows
    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable(value="id") Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
