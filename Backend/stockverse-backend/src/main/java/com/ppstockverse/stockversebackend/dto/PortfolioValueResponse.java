package com.ppstockverse.stockversebackend.dto;

public class PortfolioValueResponse {

    private Long userId;
    private Double totalInvestment;

    public PortfolioValueResponse(Long userId, Double totalInvestment) {
        this.userId = userId;
        this.totalInvestment = totalInvestment;
    }

    public Long getUserId() {
        return userId;
    }

    public Double getTotalInvestment() {
        return totalInvestment;
    }
}