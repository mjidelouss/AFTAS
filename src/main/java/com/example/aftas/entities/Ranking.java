package com.example.aftas.entities;

import jakarta.persistence.*;

@Entity
public class Ranking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int rank;
    private int score;
    @ManyToOne
    private Member member;
    @ManyToOne
    private Competition competition;

}
