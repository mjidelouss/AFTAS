package com.example.aftas.service;

import com.example.aftas.entities.Rank;

import java.util.List;

public interface RankingService {
    Rank getRankingById(Long id);

    Rank addRanking(Rank rank);

    Rank updateRanking(Rank rank, Long id);

    void deleteRanking(Long id);

    List<Rank> getRankings();
}
