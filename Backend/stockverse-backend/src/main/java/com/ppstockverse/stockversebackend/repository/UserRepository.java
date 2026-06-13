package com.ppstockverse.stockversebackend.repository;

import com.ppstockverse.stockversebackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);

}