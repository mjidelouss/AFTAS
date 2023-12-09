package com.example.aftas.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Competition {
    @Id
    private String code;
    private LocalDate date;
    private String startTime;
    private String endTime;
    private int totalParticipants;
    private String location;
    private int totalFish;
    @OneToMany(mappedBy = "competition")
    private List<Ranking> rankings;
}
