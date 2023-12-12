package com.example.aftas.VMs.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class LevelRequest {
    @NotNull(message = "Level Cannot Be Null")
    @Positive(message = "Level Must Be Positive")
    private Integer level;

    @NotNull(message = "Description Cannot Be Null")
    @NotBlank(message = "Description Cannot Be Blank")
    private String description;

    @Positive(message = "Points Must Be Positive")
    private Integer points;
}
