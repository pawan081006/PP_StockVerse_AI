package com.ppstockverse.stockversebackend.service;

import com.ppstockverse.stockversebackend.dto.UserLoginRequest;
import com.ppstockverse.stockversebackend.dto.UserRegisterRequest;
import com.ppstockverse.stockversebackend.dto.UserResponse;
import com.ppstockverse.stockversebackend.entity.User;
import com.ppstockverse.stockversebackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Register User
    public User saveUser(UserRegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists!");
        }

        User user = new User();

        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        return userRepository.save(user);
    }

    // Login User
    public UserResponse loginUser(UserLoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail());

        if (user == null) {
            throw new RuntimeException("User not found!");
        }

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid Password!");
        }

        return new UserResponse(
                user.getId(),
                user.getFullName(),
                user.getEmail()
        );
    }
}