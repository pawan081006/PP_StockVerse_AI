package com.ppstockverse.stockversebackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "paper_account")
public class PaperAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Double balance;

    public PaperAccount() {
    }

    public PaperAccount(Long id, Long userId, Double balance) {
        this.id = id;
        this.userId = userId;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}