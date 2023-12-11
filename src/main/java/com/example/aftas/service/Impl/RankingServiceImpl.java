package com.example.aftas.service.Impl;

import com.example.aftas.entities.Rank;
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
    public Rank getRankingById(Long id) {
        return rankingRepository.findById(id).orElse(null);
    }

    @Override
    public Rank addRanking(Rank rank) {
        return rankingRepository.save(rank);
    }

    @Override
    public Rank updateRanking(Rank rank, Long id) {
        Rank existingRank = getRankingById(id);
        existingRank.setRank(rank.getRank());
        existingRank.setScore(rank.getScore());
        return rankingRepository.save(existingRank);
    }

    @Override
    public void deleteRanking(Long id) {
        rankingRepository.deleteById(id);
    }

    @Override
    public List<Rank> getRankings() {
        return rankingRepository.findAll();
    }
}
