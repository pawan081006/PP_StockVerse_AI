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

    // Get Stock By Id
    public Stock getStockById(Long id) {
        return stockRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stock not found!"));
    }

    // Update Stock
    public Stock updateStock(Long id, Stock updatedStock) {

        Stock stock = stockRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stock not found!"));

        stock.setSymbol(updatedStock.getSymbol());
        stock.setCompanyName(updatedStock.getCompanyName());
        stock.setSector(updatedStock.getSector());

        return stockRepository.save(stock);
    }

    // Delete Stock
    public void deleteStock(Long id) {

        Stock stock = stockRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stock not found!"));

        stockRepository.delete(stock);
    }
}