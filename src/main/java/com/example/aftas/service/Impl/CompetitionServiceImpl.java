package com.example.aftas.service.Impl;

import com.example.aftas.entities.Competition;
import com.example.aftas.repository.CompetitionRepository;
import com.example.aftas.service.CompetitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompetitionServiceImpl implements CompetitionService {

    private final CompetitionRepository competitionRepository;

    @Override
    public Competition addCompetition(Competition competition) {
        competition.setCode(generateCompetitionCode(competition));
        return competitionRepository.save(competition);
    }

    @Override
    public Competition updateCompetition(Competition competition, Long id) {
        Competition existingCompetition = getCompetitionById(id);
        existingCompetition.setAmount(competition.getAmount());
        existingCompetition.setCode(competition.getCode());
        existingCompetition.setDate(competition.getDate());
        existingCompetition.setLocation(competition.getLocation());
        existingCompetition.setStartTime(competition.getStartTime());
        existingCompetition.setEndTime(competition.getEndTime());
        existingCompetition.setTotalParticipants(competition.getTotalParticipants());
        return competitionRepository.save(existingCompetition);
    }

    @Override
    public Competition getCompetitionById(Long id) {
        return competitionRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCompetition(Long id) {
        competitionRepository.deleteById(id);
    }

    @Override
    public List<Competition> getCompetitions() {
        return competitionRepository.findAll();
    }

    public String generateCompetitionCode(Competition competition) {
        String locationCode = competition.getLocation().substring(0, 3).toLowerCase();
        String dateCode = competition.getDate().format(DateTimeFormatter.ofPattern("yy-MM-dd"));
        return locationCode + "-" + dateCode;
    }

    public void validateCompetitionDate(Competition newCompetition) {
        LocalDate competitionDate = newCompetition.getDate();
        List<Competition> existingCompetitionsOnDate = competitionRepository.findByDate(competitionDate);

        if (!existingCompetitionsOnDate.isEmpty()) {
            throw new IllegalArgumentException("Another competition already exists on the same date");
        }
    }
}
