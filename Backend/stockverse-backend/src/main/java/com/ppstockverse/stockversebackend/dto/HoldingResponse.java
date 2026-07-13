package com.ppstockverse.stockversebackend.dto;

public class HoldingResponse {

    private Long stockId;
    private Integer quantity;

    public HoldingResponse(Long stockId, Integer quantity) {
        this.stockId = stockId;
        this.quantity = quantity;
    }

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}