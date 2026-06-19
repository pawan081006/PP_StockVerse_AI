

        package com.ppstockverse.stockversebackend.service;

import com.ppstockverse.stockversebackend.entity.PaperAccount;
import com.ppstockverse.stockversebackend.repository.PaperAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaperAccountService {

    @Autowired
    private PaperAccountRepository paperAccountRepository;

    // Create Virtual Account
    public PaperAccount createAccount(Long userId) {

        PaperAccount existingAccount =
                paperAccountRepository.findByUserId(userId).orElse(null);

        // Account already exists
        if (existingAccount != null) {
            return existingAccount;
        }

        // Create new account with ₹10,00,000
        PaperAccount account = new PaperAccount();

        account.setUserId(userId);
        account.setBalance(1000000.0);

        return paperAccountRepository.save(account);
    }

    // Get User Balance
    public PaperAccount getAccount(Long userId) {

        return paperAccountRepository.findByUserId(userId)
                .orElseThrow(() ->
                        new RuntimeException("Paper Account Not Found"));
    }

    // Deduct Balance
    public void deductBalance(Long userId, Double amount) {

        PaperAccount account = paperAccountRepository.findByUserId(userId)
                .orElseThrow(() ->
                        new RuntimeException("Paper Account Not Found"));

        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient Balance");
        }

        account.setBalance(account.getBalance() - amount);

        paperAccountRepository.save(account);
    }

    // Add Balance
    public void addBalance(Long userId, Double amount) {

        PaperAccount account = paperAccountRepository.findByUserId(userId)
                .orElseThrow(() ->
                        new RuntimeException("Paper Account Not Found"));

        account.setBalance(account.getBalance() + amount);

        paperAccountRepository.save(account);
    }
}

