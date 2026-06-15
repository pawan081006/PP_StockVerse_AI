package com.ppstockverse.stockversebackend.dto;

public class PortfolioProfitResponse {

    private Long userId;
    private Double investment;
    private Double currentValue;
    private Double profit;
    private Double profitPercent;

    public PortfolioProfitResponse(Long userId,
                                   Double investment,
                                   Double currentValue,
                                   Double profit,
                                   Double profitPercent) {

        this.userId = userId;
        this.investment = investment;
        this.currentValue = currentValue;
        this.profit = profit;
        this.profitPercent = profitPercent;
    }

    public Long getUserId() {
        return userId;
    }

    public Double getInvestment() {
        return investment;
    }

    public Double getCurrentValue() {
        return currentValue;
    }

    public Double getProfit() {
        return profit;
    }

    public Double getProfitPercent() {
        return profitPercent;
    }
}