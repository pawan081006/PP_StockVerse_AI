package com.ppstockverse.stockversebackend.repository;

import com.ppstockverse.stockversebackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    // Check if email already exists
    boolean existsByEmail(String email);

    // Find user by email (for Login API)
    User findByEmail(String email);

}