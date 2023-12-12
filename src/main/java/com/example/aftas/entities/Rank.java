package com.example.aftas.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Positive(message = "Rank must be Positive")
    @NotNull(message = "Rank cannot be Null")
    @Column(columnDefinition = "integer default 0")
    private Integer rank;

    @PositiveOrZero(message = "Score must be Positive")
    @NotNull(message = "Score cannot be Null")
    @Column(columnDefinition = "integer default 0")
    private Integer score;

    @ManyToOne
    @JoinColumn(name = "member_id")
    @NotNull(message = "Member cannot be Null")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "competition_id")
    @NotNull(message = "Competition cannot be Null")
    private Competition competition;

}
