package com.ppstockverse.stockversebackend.service;

import com.ppstockverse.stockversebackend.entity.Stock;
import com.ppstockverse.stockversebackend.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    // Add New Stock
    public Stock saveStock(Stock stock) {
        return stockRepository.save(stock);
    }

    // Get All Stocks
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }
}