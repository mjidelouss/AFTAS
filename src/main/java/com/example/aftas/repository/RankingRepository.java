package com.example.aftas.repository;

import com.example.aftas.entities.Rank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RankingRepository extends JpaRepository<Rank, Long> {

}
