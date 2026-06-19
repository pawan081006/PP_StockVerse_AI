package com.ppstockverse.stockversebackend.controller;

import com.ppstockverse.stockversebackend.entity.PaperAccount;
import com.ppstockverse.stockversebackend.service.PaperAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/paperaccount")
public class PaperAccountController {

    @Autowired
    private PaperAccountService paperAccountService;

    // Create Virtual Account
    @PostMapping("/{userId}")
    public PaperAccount createAccount(@PathVariable Long userId) {

        return paperAccountService.createAccount(userId);
    }

    // Get User Balance
    @GetMapping("/{userId}")
    public PaperAccount getAccount(@PathVariable Long userId) {

        return paperAccountService.getAccount(userId);
    }

}