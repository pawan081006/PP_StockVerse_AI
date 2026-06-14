package com.ppstockverse.stockversebackend.repository;

import com.ppstockverse.stockversebackend.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

}