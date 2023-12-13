package com.example.aftas.repository;

import com.example.aftas.entities.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, Long> {

    List<Competition> findByDate(LocalDate competitionDate);

    Competition findByCode(String competitionCode);
}
