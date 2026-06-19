package com.ppstockverse.stockversebackend.repository;

import com.ppstockverse.stockversebackend.entity.PaperTrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaperTradeRepository extends JpaRepository<PaperTrade, Long> {

    // Get all trades of a user
    List<PaperTrade> findByUserId(Long userId);

    // Get specific stock trade of a user
    Optional<PaperTrade> findByUserIdAndStockId(Long userId, Long stockId);

}