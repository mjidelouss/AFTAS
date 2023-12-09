package com.example.aftas.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int level;
    private String description;
    private int points;
    @OneToMany(mappedBy = "level")
    private List<Fish> fishList;
}
