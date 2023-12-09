package com.example.aftas.entities;

import jakarta.persistence.*;
import com.example.aftas.entities.Level;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Fish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Name must not be Null")
    private String name;
    @NotNull(message = "AverageWeight must not be Null")
    private double averageWeight;
    @OneToMany(mappedBy = "fish")
    private List<Hunting> huntings;
    @ManyToOne
    private Level level;
}
