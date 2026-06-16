package com.ppstockverse.stockversebackend.service;

import com.ppstockverse.stockversebackend.entity.Watchlist;
import com.ppstockverse.stockversebackend.repository.WatchlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchlistService {

    @Autowired
    private WatchlistRepository watchlistRepository;

    // Add Stock to Watchlist
    public Watchlist addToWatchlist(Watchlist watchlist) {
        return watchlistRepository.save(watchlist);
    }

    // Get User Watchlist
    public List<Watchlist> getUserWatchlist(Long userId) {
        return watchlistRepository.findByUserId(userId);
    }

    // Remove Stock from Watchlist
    public void removeFromWatchlist(Long id) {
        watchlistRepository.deleteById(id);
    }
}
