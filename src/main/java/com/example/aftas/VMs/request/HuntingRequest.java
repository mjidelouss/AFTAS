package com.example.aftas.VMs.request;

import com.example.aftas.entities.Fish;
import com.example.aftas.entities.Member;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class HuntingRequest {

    @NotNull(message = "Number Of Fish Cannot Be Null")
    @PositiveOrZero(message = "Number Of Fish Must Be Positive")
    private Integer numberOfFish;
    @NotNull(message = "Member Cannot Be Null")
    private Member member;
    @NotNull(message = "Fish Cannot Be Null")
    private Fish fish;
}
