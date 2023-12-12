package com.example.aftas.repository;

import com.example.aftas.entities.Competition;
import com.example.aftas.entities.Member;
import com.example.aftas.entities.Rank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RankingRepository extends JpaRepository<Rank, Long> {

    Rank findByMemberAndCompetition(Member member, Competition competition);

    List<Rank> findByCompetitionOrderByScoreDesc(Competition competition);
}
