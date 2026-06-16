package com.ppstockverse.stockversebackend.controller;

import com.ppstockverse.stockversebackend.entity.Watchlist;
import com.ppstockverse.stockversebackend.service.WatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/watchlist")
public class WatchlistController {

    @Autowired
    private WatchlistService watchlistService;

    // Add Stock to Watchlist
    @PostMapping
    public Watchlist addStock(@RequestBody Watchlist watchlist) {
        return watchlistService.addToWatchlist(watchlist);
    }

    // Get User Watchlist
    @GetMapping("/{userId}")
    public List<Watchlist> getWatchlist(@PathVariable Long userId) {
        return watchlistService.getUserWatchlist(userId);
    }

    // Remove Stock from Watchlist
    @DeleteMapping("/{id}")
    public String removeStock(@PathVariable Long id) {

        watchlistService.removeFromWatchlist(id);

        return "Stock removed from Watchlist Successfully!";
    }
}