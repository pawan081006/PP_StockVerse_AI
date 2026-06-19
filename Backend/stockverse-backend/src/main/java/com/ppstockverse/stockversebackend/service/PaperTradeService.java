
package com.ppstockverse.stockversebackend.service;

import com.ppstockverse.stockversebackend.entity.PaperTrade;
import com.ppstockverse.stockversebackend.repository.PaperTradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaperTradeService {

    @Autowired
    private PaperTradeRepository paperTradeRepository;

    @Autowired
    private PaperAccountService paperAccountService;

    // Buy Stock
    public PaperTrade buyStock(PaperTrade paperTrade) {

        // Calculate Total Amount
        double totalAmount =
                paperTrade.getQuantity() * paperTrade.getBuyPrice();

        // Deduct Balance from Wallet
        paperAccountService.deductBalance(
                paperTrade.getUserId(),
                totalAmount
        );

        // Save Trade Time
        paperTrade.setTradeTime(LocalDateTime.now());

        // Save Trade
        return paperTradeRepository.save(paperTrade);
    }

    // Get User Trades
    public List<PaperTrade> getUserTrades(Long userId) {

        return paperTradeRepository.findByUserId(userId);
    }

    // Delete Trade
    public void deleteTrade(Long id) {

        paperTradeRepository.deleteById(id);
    }
}

