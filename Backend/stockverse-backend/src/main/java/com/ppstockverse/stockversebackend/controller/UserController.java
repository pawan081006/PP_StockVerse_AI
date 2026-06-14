package com.ppstockverse.stockversebackend.controller;

import com.ppstockverse.stockversebackend.dto.UserLoginRequest;
import com.ppstockverse.stockversebackend.dto.UserRegisterRequest;
import com.ppstockverse.stockversebackend.dto.UserResponse;
import com.ppstockverse.stockversebackend.entity.User;
import com.ppstockverse.stockversebackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody UserRegisterRequest request) {
        return userService.saveUser(request);
    }

    @PostMapping("/login")
    public UserResponse loginUser(@RequestBody UserLoginRequest request) {
        return userService.loginUser(request);
    }
}