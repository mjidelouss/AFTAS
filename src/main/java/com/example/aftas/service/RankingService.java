package com.example.aftas.service;

import com.example.aftas.entities.Ranking;

public interface RankingService {
    Ranking getRankingById(Long id);

    Ranking addRanking(Ranking ranking);

    Ranking updateRanking(Ranking ranking, Long id);

    void deleteRanking(Long id);
}
