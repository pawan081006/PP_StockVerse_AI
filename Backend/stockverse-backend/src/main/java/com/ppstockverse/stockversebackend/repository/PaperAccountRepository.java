package com.ppstockverse.stockversebackend.repository;

import com.ppstockverse.stockversebackend.entity.PaperAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaperAccountRepository extends JpaRepository<PaperAccount, Long> {

    Optional<PaperAccount> findByUserId(Long userId);

}