package com.example.aftas.VMs.response;

import com.example.aftas.entities.Rank;
import com.example.aftas.enums.CompetitionStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompetitionResponse {
    private String code;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer totalParticipants;
    private String location;
    private Double amount;
    private CompetitionStatus status;
    private List<Rank> ranks;
}
