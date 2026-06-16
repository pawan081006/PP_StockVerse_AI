package com.ppstockverse.stockversebackend.controller;

import com.ppstockverse.stockversebackend.dto.PortfolioProfitResponse;
import com.ppstockverse.stockversebackend.dto.PortfolioValueResponse;
import com.ppstockverse.stockversebackend.dto.SellStockRequest;
import com.ppstockverse.stockversebackend.entity.Portfolio;
import com.ppstockverse.stockversebackend.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/portfolio")
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    // Buy Stock
    @PostMapping
    public Portfolio buyStock(@RequestBody Portfolio portfolio) {
        return portfolioService.buyStock(portfolio);
    }

    // Get User Portfolio
    @GetMapping("/{userId}")
    public List<Portfolio> getPortfolio(@PathVariable Long userId) {
        return portfolioService.getPortfolioByUserId(userId);
    }

    // Get Total Investment
    @GetMapping("/value/{userId}")
    public PortfolioValueResponse getPortfolioValue(@PathVariable Long userId) {

        Double totalInvestment =
                portfolioService.calculateTotalInvestment(userId);

        return new PortfolioValueResponse(userId, totalInvestment);
    }

    // Get Profit / Loss
    @GetMapping("/profit/{userId}")
    public PortfolioProfitResponse getProfit(@PathVariable Long userId) {

        return portfolioService.calculateProfit(userId);
    }

    // Sell Stock
    @PostMapping("/sell")
    public Portfolio sellStock(@RequestBody SellStockRequest request) {

        return portfolioService.sellStock(
                request.getUserId(),
                request.getStockId(),
                request.getQuantity()
        );
    }
}