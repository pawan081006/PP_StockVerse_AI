package com.ppstockverse.stockversebackend.dto;

public class PortfolioSummaryResponse {

    private Double walletBalance;
    private Double totalInvestment;
    private Double portfolioValue;
    private Double profitLoss;
    private Integer totalHoldings;
    private Integer totalTrades;

    public PortfolioSummaryResponse() {
    }

    public PortfolioSummaryResponse(
            Double walletBalance,
            Double totalInvestment,
            Double portfolioValue,
            Double profitLoss,
            Integer totalHoldings,
            Integer totalTrades) {

        this.walletBalance = walletBalance;
        this.totalInvestment = totalInvestment;
        this.portfolioValue = portfolioValue;
        this.profitLoss = profitLoss;
        this.totalHoldings = totalHoldings;
        this.totalTrades = totalTrades;
    }

    public Double getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(Double walletBalance) {
        this.walletBalance = walletBalance;
    }

    public Double getTotalInvestment() {
        return totalInvestment;
    }

    public void setTotalInvestment(Double totalInvestment) {
        this.totalInvestment = totalInvestment;
    }

    public Double getPortfolioValue() {
        return portfolioValue;
    }

    public void setPortfolioValue(Double portfolioValue) {
        this.portfolioValue = portfolioValue;
    }

    public Double getProfitLoss() {
        return profitLoss;
    }

    public void setProfitLoss(Double profitLoss) {
        this.profitLoss = profitLoss;
    }

    public Integer getTotalHoldings() {
        return totalHoldings;
    }

    public void setTotalHoldings(Integer totalHoldings) {
        this.totalHoldings = totalHoldings;
    }

    public Integer getTotalTrades() {
        return totalTrades;
    }

    public void setTotalTrades(Integer totalTrades) {
        this.totalTrades = totalTrades;
    }
}