//package com.ppstockverse.stockversebackend.repository;
//
//import com.ppstockverse.stockversebackend.entity.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//public interface UserRepository extends JpaRepository<User, Long> {
//
//    // Check if email already exists
//    boolean existsByEmail(String email);
//
//    // Find user by email (for Login API)
//    User findByEmail(String email);
//
//}



        package com.ppstockverse.stockversebackend.repository;

import com.ppstockverse.stockversebackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Check if email already exists
    boolean existsByEmail(String email);

    // Find user by email
    Optional<User> findByEmail(String email);

}

