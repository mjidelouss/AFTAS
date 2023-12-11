package com.example.aftas.service;

import com.example.aftas.entities.Competition;

public interface CompetitionService {

    Competition addCompetition(Competition competition);

    Competition updateCompetition(Competition competition, Long id);

    Competition getCompetitionById(Long id);

    void deleteCompetition(Long id);
}
