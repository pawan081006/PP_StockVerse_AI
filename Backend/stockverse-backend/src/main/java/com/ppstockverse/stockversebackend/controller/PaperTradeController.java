package com.ppstockverse.stockversebackend.controller;

import com.ppstockverse.stockversebackend.dto.HoldingResponse;
import com.ppstockverse.stockversebackend.dto.PortfolioSummaryResponse;
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

    // BUY STOCK
    @PostMapping("/buy")
    public PaperTrade buyStock(@RequestBody PaperTrade paperTrade) {

        return paperTradeService.buyStock(paperTrade);
    }

    // SELL STOCK
    @PostMapping("/sell")
    public PaperTrade sellStock(@RequestBody PaperTrade paperTrade) {

        return paperTradeService.sellStock(paperTrade);
    }

    // GET USER TRADES
    @GetMapping("/{userId}")
    public List<PaperTrade> getUserTrades(@PathVariable Long userId) {

        return paperTradeService.getUserTrades(userId);
    }

    // GET USER HOLDINGS
    @GetMapping("/holdings/{userId}")
    public List<HoldingResponse> getUserHoldings(
            @PathVariable Long userId) {

        return paperTradeService.getUserHoldings(userId);
    }

    // GET PORTFOLIO SUMMARY
    @GetMapping("/summary/{userId}")
    public PortfolioSummaryResponse getPortfolioSummary(
            @PathVariable Long userId) {

        return paperTradeService.getPortfolioSummary(userId);
    }

    // DELETE TRADE
    @DeleteMapping("/{id}")
    public String deleteTrade(@PathVariable Long id) {

        paperTradeService.deleteTrade(id);

        return "Paper Trade Deleted Successfully!";
    }
}