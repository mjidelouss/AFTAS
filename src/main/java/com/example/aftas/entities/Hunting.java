package com.example.aftas.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Hunting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numberOfFish;
    @ManyToOne
    private Member member;
    @ManyToOne
    private Fish fish;
}
