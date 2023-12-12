package com.example.aftas.VMs.request;

import com.example.aftas.enums.CompetitionStatus;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class CompetitionRequest {

    @NotNull(message = "Code Cannot be Null")
    @NotBlank(message = "Code Cannot be Blank")
    private String code;

    @NotNull(message = "Date Cannot Be Null")
    @Future(message = "Date Must Be in the Future")
    private LocalDate date;

    @NotNull(message = "Start Time Cannot be Null")
    private LocalTime startTime;

    @NotNull(message = "End Time Cannot be Null")
    private LocalTime endTime;

    @NotNull(message = "Total of Participants Cannot be Null")
    @Positive(message = "Total of Participants Must Be Positive")
    private Integer totalParticipants;

    @NotNull(message = "Location Cannot be Null")
    @NotBlank(message = "Location Cannot be Blank")
    private String location;

    @NotNull(message = "Amount Cannot be Null")
    @Positive(message = "Amount Must Be Positive")
    private Double amount;

    @NotNull(message = "Status Cannot be Null")
    private CompetitionStatus status;
}
