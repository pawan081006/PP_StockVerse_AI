package com.ppstockverse.stockversebackend.service;

import com.ppstockverse.stockversebackend.dto.HoldingResponse;
import com.ppstockverse.stockversebackend.dto.PortfolioSummaryResponse;
import com.ppstockverse.stockversebackend.entity.PaperAccount;
import com.ppstockverse.stockversebackend.entity.PaperTrade;
import com.ppstockverse.stockversebackend.repository.PaperTradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PaperTradeService {

    @Autowired
    private PaperTradeRepository paperTradeRepository;

    @Autowired
    private PaperAccountService paperAccountService;

    // BUY STOCK
    public PaperTrade buyStock(PaperTrade paperTrade) {

        double totalAmount =
                paperTrade.getQuantity() * paperTrade.getBuyPrice();

        paperAccountService.deductBalance(
                paperTrade.getUserId(),
                totalAmount
        );

        paperTrade.setTradeType("BUY");
        paperTrade.setTradeTime(LocalDateTime.now());

        return paperTradeRepository.save(paperTrade);
    }

    // SELL STOCK
    public PaperTrade sellStock(PaperTrade paperTrade) {

        double totalAmount =
                paperTrade.getQuantity() * paperTrade.getSellPrice();

        paperAccountService.addBalance(
                paperTrade.getUserId(),
                totalAmount
        );

        paperTrade.setTradeType("SELL");
        paperTrade.setTradeTime(LocalDateTime.now());

        return paperTradeRepository.save(paperTrade);
    }

    // GET USER TRADES
    public List<PaperTrade> getUserTrades(Long userId) {

        return paperTradeRepository.findByUserId(userId);
    }

    // GET USER HOLDINGS
    public List<HoldingResponse> getUserHoldings(Long userId) {

        List<PaperTrade> trades =
                paperTradeRepository.findByUserId(userId);

        Map<Long, Integer> holdings = new HashMap<>();

        for (PaperTrade trade : trades) {

            holdings.putIfAbsent(trade.getStockId(), 0);

            if ("BUY".equals(trade.getTradeType())) {

                holdings.put(
                        trade.getStockId(),
                        holdings.get(trade.getStockId()) + trade.getQuantity()
                );

            } else if ("SELL".equals(trade.getTradeType())) {

                holdings.put(
                        trade.getStockId(),
                        holdings.get(trade.getStockId()) - trade.getQuantity()
                );
            }
        }

        List<HoldingResponse> result = new ArrayList<>();

        for (Map.Entry<Long, Integer> entry : holdings.entrySet()) {

            if (entry.getValue() > 0) {

                result.add(
                        new HoldingResponse(
                                entry.getKey(),
                                entry.getValue()
                        )
                );
            }
        }

        return result;
    }

    // PORTFOLIO SUMMARY
    public PortfolioSummaryResponse getPortfolioSummary(Long userId) {

        PaperAccount account =
                paperAccountService.getAccount(userId);

        List<PaperTrade> trades =
                paperTradeRepository.findByUserId(userId);

        int totalTrades = trades.size();

        int totalHoldings = 0;

        double totalInvestment = 0.0;

        for (PaperTrade trade : trades) {

            if ("BUY".equals(trade.getTradeType())) {

                totalHoldings += trade.getQuantity();

                totalInvestment +=
                        trade.getQuantity() * trade.getBuyPrice();

            } else if ("SELL".equals(trade.getTradeType())) {

                totalHoldings -= trade.getQuantity();
            }
        }

        // Live API aane tak
        double portfolioValue = totalInvestment;

        double profitLoss = portfolioValue - totalInvestment;

        return new PortfolioSummaryResponse(

                account.getBalance(),
                totalInvestment,
                portfolioValue,
                profitLoss,
                totalHoldings,
                totalTrades
        );
    }

    // DELETE TRADE
    public void deleteTrade(Long id) {

        paperTradeRepository.deleteById(id);
    }
}