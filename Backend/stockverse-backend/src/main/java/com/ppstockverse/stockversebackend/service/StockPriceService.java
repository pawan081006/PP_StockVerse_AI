package com.ppstockverse.stockversebackend.service;

import com.ppstockverse.stockversebackend.dto.StockPriceResponse;
import org.springframework.stereotype.Service;

@Service
public class StockPriceService {

    // Temporary Live Price Service
    public StockPriceResponse getCurrentPrice(String symbol) {

        // Temporary Dummy Price
        double currentPrice = 3921.45;

        return new StockPriceResponse(symbol, currentPrice);
    }
}