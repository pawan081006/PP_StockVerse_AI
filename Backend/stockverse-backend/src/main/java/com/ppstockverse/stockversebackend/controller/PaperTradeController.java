package com.ppstockverse.stockversebackend.controller;

import com.ppstockverse.stockversebackend.entity.PaperTrade;
import com.ppstockverse.stockversebackend.service.PaperTradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/papertrade")
public class PaperTradeController {

    @Autowired
    private PaperTradeService paperTradeService;

    // Buy Stock
    @PostMapping
    public PaperTrade buyStock(@RequestBody PaperTrade paperTrade) {
        return paperTradeService.buyStock(paperTrade);
    }

    // Get User Trades
    @GetMapping("/{userId}")
    public List<PaperTrade> getUserTrades(@PathVariable Long userId) {
        return paperTradeService.getUserTrades(userId);
    }

    // Delete Trade
    @DeleteMapping("/{id}")
    public String deleteTrade(@PathVariable Long id) {

        paperTradeService.deleteTrade(id);

        return "Paper Trade Deleted Successfully!";
    }
}