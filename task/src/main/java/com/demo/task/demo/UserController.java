package com.demo.task.demo;

import com.demo.task.dmo.Task;
import com.demo.task.dmo.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/user")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO createdUser=userService.createUser(userDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUsers() {
    List<User> users=userService.getAllUsers();
    return new ResponseEntity<>(users, HttpStatus.OK);
}
}
