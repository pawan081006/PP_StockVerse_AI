package com.ppstockverse.stockversebackend.controller;

import com.ppstockverse.stockversebackend.entity.Stock;
import com.ppstockverse.stockversebackend.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    // Add New Stock
    @PostMapping
    public Stock addStock(@RequestBody Stock stock) {
        return stockService.saveStock(stock);
    }

    // Get All Stocks
    @GetMapping
    public List<Stock> getAllStocks() {
        return stockService.getAllStocks();
    }

    // Get Stock By Id
    @GetMapping("/{id}")
    public Stock getStockById(@PathVariable Long id) {
        return stockService.getStockById(id);
    }

    // Update Stock
    @PutMapping("/{id}")
    public Stock updateStock(@PathVariable Long id,
                             @RequestBody Stock stock) {

        return stockService.updateStock(id, stock);
    }

    // Delete Stock
    @DeleteMapping("/{id}")
    public String deleteStock(@PathVariable Long id) {

        stockService.deleteStock(id);

        return "Stock deleted successfully!";
    }
}