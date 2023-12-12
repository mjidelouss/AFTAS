package com.example.aftas.VMs.request;

import com.example.aftas.entities.Level;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
public class FishRequest {
    @NotNull(message = "Name must not be Null")
    @NotBlank(message = "Name Cannot Be Null")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Name must only contain letters")
    private String name;

    @NotNull(message = "AverageWeight must not be Null")
    @Positive(message = "Average weight must be positive")
    private Double averageWeight;

    @NotNull(message = "Level Cannot Be Null")
    private Level level;
}
