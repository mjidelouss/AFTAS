package com.example.aftas.service.Impl;

import com.example.aftas.entities.Ranking;
import com.example.aftas.repository.RankingRepository;
import com.example.aftas.service.RankingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RankingServiceImpl implements RankingService {

    private final RankingRepository rankingRepository;
    @Override
    public Ranking getRankingById(Long id) {
        return rankingRepository.findById(id).orElse(null);
    }

    @Override
    public Ranking addRanking(Ranking ranking) {
        return rankingRepository.save(ranking);
    }

    @Override
    public Ranking updateRanking(Ranking ranking, Long id) {
        Ranking existingRanking = getRankingById(id);
        existingRanking.setRank(ranking.getRank());
        existingRanking.setScore(ranking.getScore());
        return rankingRepository.save(existingRanking);
    }

    @Override
    public void deleteRanking(Long id) {
        rankingRepository.deleteById(id);
    }

    @Override
    public List<Ranking> getRankings() {
        return rankingRepository.findAll();
    }
}
