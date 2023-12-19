package com.example.aftas.service.Impl;

import com.example.aftas.entities.*;
import com.example.aftas.enums.CompetitionStatus;
import com.example.aftas.enums.IdentityDocumentType;
import com.example.aftas.repository.RankingRepository;
import com.example.aftas.service.RankingService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class RankingServiceImplTest {
    @Mock
    private RankingRepository rankingRepository;

    @Mock
    private RankingService rankingService;

    @Test
    void testUpdateScoreWhenRankIsNull() {
        Member member = new Member("John", "Doe", 123456, LocalDate.now(), "USA", IdentityDocumentType.PASSPORT, "AB123456");
        Competition competition = new Competition("ABC123", LocalDate.now(), LocalTime.now(), LocalTime.now().plusHours(2), 50, "City Park", 75.0, CompetitionStatus.IN_PROGRESS);
        Level level = new Level(1, "Beginner", 50);
        Fish fish = new Fish("Salmon", 5.0, level);
        Rank rank = null;

        Mockito.when(rankingRepository.findByMemberAndCompetition(member, competition)).thenReturn(rank);
        rankingService.updateScore(member, competition, fish);
        Mockito.verify(rankingRepository).save(Mockito.any(Rank.class));
    }

    @Test
    void testUpdateRankingOrderWithSameScore() {
        Competition competition = new Competition("ABC123", LocalDate.now(), LocalTime.now(), LocalTime.now().plusHours(2), 50, "City Park", 75.0, CompetitionStatus.IN_PROGRESS);
        Rank rank1 = Rank.builder().id(new RankId()).rank(1).score(100).competition(competition).build();
        Rank rank2 = Rank.builder().id(new RankId()).rank(2).score(90).competition(competition).build();
        Rank rank3 = Rank.builder().id(new RankId()).rank(3).score(90).competition(competition).build();
        List<Rank> ranks = new ArrayList<>();
        ranks.add(rank1);
        ranks.add(rank2);
        ranks.add(rank3);

        Mockito.when(rankingRepository.findByCompetitionOrderByScoreDesc(competition)).thenReturn(ranks);
        rankingService.updateRankingOrder(competition);
        Mockito.verify(rankingRepository, Mockito.times(ranks.size())).save(Mockito.any(Rank.class));
    }

    @Test
    void testUpdateRankingOrderWithDifferentScores() {
        Competition competition = new Competition("ABC123", LocalDate.now(), LocalTime.now(), LocalTime.now().plusHours(2), 50, "City Park", 75.0, CompetitionStatus.IN_PROGRESS);
        Rank rank1 = Rank.builder().id(new RankId()).rank(1).score(100).competition(competition).build();
        Rank rank2 = Rank.builder().id(new RankId()).rank(2).score(900).competition(competition).build();
        Rank rank3 = Rank.builder().id(new RankId()).rank(3).score(90).competition(competition).build();
        List<Rank> ranks = new ArrayList<>();
        ranks.add(rank1);
        ranks.add(rank2);
        ranks.add(rank3);

        Mockito.when(rankingRepository.findByCompetitionOrderByScoreDesc(competition)).thenReturn(ranks);
        rankingService.updateRankingOrder(competition);
        Mockito.verify(rankingRepository, Mockito.times(ranks.size())).save(Mockito.any(Rank.class));
    }
}