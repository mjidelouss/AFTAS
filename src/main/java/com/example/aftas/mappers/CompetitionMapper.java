package com.example.aftas.mappers;

import com.example.aftas.VMs.request.CompetitionRequest;
import com.example.aftas.VMs.response.CompetitionResponse;
import com.example.aftas.entities.Competition;
import com.example.aftas.enums.CompetitionStatus;

public class CompetitionMapper {

    public static Competition mapCompetitionRequestToCompetition(CompetitionRequest competitionRequest) {
        return Competition.builder()
                .amount(competitionRequest.getAmount())
                .date(competitionRequest.getDate())
                .code(competitionRequest.getCode())
                .startTime(competitionRequest.getStartTime())
                .endTime(competitionRequest.getEndTime())
                .location(competitionRequest.getLocation())
                .totalParticipants(competitionRequest.getTotalParticipants())
                .status(CompetitionStatus.OPEN)
                .build();
    }

    public static CompetitionResponse mapCompetitionToCompetitionResponse(Competition competition) {
        return CompetitionResponse.builder()
                .code(competition.getCode())
                .amount(competition.getAmount())
                .date(competition.getDate())
                .startTime(competition.getStartTime())
                .endTime(competition.getEndTime())
                .location(competition.getLocation())
                .totalParticipants(competition.getTotalParticipants())
                .build();
    }
}
