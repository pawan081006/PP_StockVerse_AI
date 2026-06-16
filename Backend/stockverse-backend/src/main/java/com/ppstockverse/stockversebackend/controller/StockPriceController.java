package com.ppstockverse.stockversebackend.controller;

import com.ppstockverse.stockversebackend.dto.StockPriceResponse;
import com.ppstockverse.stockversebackend.service.StockPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/price")
public class StockPriceController {

    @Autowired
    private StockPriceService stockPriceService;

    // Get Current Stock Price
    @GetMapping("/{symbol}")
    public StockPriceResponse getPrice(@PathVariable String symbol) {

        return stockPriceService.getCurrentPrice(symbol);
    }
}

