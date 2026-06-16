package com.ppstockverse.stockversebackend.dto;

public class StockPriceResponse {

    private String symbol;
    private Double currentPrice;

    public StockPriceResponse(String symbol, Double currentPrice) {
        this.symbol = symbol;
        this.currentPrice = currentPrice;
    }

    public String getSymbol() {
        return symbol;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }
}