package com.example.aftas.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;

@Entity
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private Integer level;
    @NotNull(message = "Description Cannot Be Null")
    @NotBlank(message = "Description Cannot Be Blank")
    private String description;
    @Column(unique = true)
    @Positive(message = "Points Must Be Positive")
    private Integer points;
    @OneToMany(mappedBy = "level")
    private List<Fish> fishList;
}
