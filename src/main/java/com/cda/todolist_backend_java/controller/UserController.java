package com.cda.todolist_backend_java.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cda.todolist_backend_java.dto.LoginRequestDTO;
import com.cda.todolist_backend_java.dto.LoginResponseDTO;
import com.cda.todolist_backend_java.entity.User;
import com.cda.todolist_backend_java.service.UserResponseDTO;
import com.cda.todolist_backend_java.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserResponseDTO register(@RequestBody User user){
        return userService.registerUser(user);
        
    }

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO loginRequest) {
        return userService.login(loginRequest);
    }
}
