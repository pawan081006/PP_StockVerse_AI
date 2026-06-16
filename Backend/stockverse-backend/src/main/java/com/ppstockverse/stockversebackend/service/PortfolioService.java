package com.ppstockverse.stockversebackend.service;

import com.ppstockverse.stockversebackend.dto.PortfolioProfitResponse;
import com.ppstockverse.stockversebackend.entity.Portfolio;
import com.ppstockverse.stockversebackend.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;

    // Buy Stock
    public Portfolio buyStock(Portfolio portfolio) {
        return portfolioRepository.save(portfolio);
    }

    // Get User Portfolio
    public List<Portfolio> getPortfolioByUserId(Long userId) {
        return portfolioRepository.findByUserId(userId);
    }

    // Calculate Total Investment
    public Double calculateTotalInvestment(Long userId) {

        List<Portfolio> portfolioList = portfolioRepository.findByUserId(userId);

        double total = 0;

        for (Portfolio portfolio : portfolioList) {
            total += portfolio.getQuantity() * portfolio.getBuyPrice();
        }

        return total;
    }

    // Calculate Profit / Loss
    public PortfolioProfitResponse calculateProfit(Long userId) {

        List<Portfolio> portfolioList = portfolioRepository.findByUserId(userId);

        double investment = 0;
        double currentValue = 0;

        for (Portfolio portfolio : portfolioList) {

            investment += portfolio.getQuantity() * portfolio.getBuyPrice();

            // Temporary Current Price
            double currentPrice = 3800;

            currentValue += portfolio.getQuantity() * currentPrice;
        }

        double profit = currentValue - investment;
        double profitPercent = (profit / investment) * 100;

        return new PortfolioProfitResponse(
                userId,
                investment,
                currentValue,
                profit,
                profitPercent
        );
    }

    // Sell Stock
    public Portfolio sellStock(Long userId, Long stockId, Integer quantity) {

        Portfolio portfolio =
                portfolioRepository.findByUserIdAndStockId(userId, stockId);

        if (portfolio == null) {
            throw new RuntimeException("Stock not found in portfolio!");
        }

        if (portfolio.getQuantity() < quantity) {
            throw new RuntimeException("Not enough shares to sell!");
        }

        int remainingQuantity = portfolio.getQuantity() - quantity;

        if (remainingQuantity == 0) {
            portfolioRepository.delete(portfolio);
            return null;
        }

        portfolio.setQuantity(remainingQuantity);

        return portfolioRepository.save(portfolio);
    }
}