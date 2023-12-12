package com.example.aftas.VMs.response;

import com.example.aftas.entities.Competition;
import com.example.aftas.entities.Fish;
import com.example.aftas.entities.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HuntingResponse {
    private Integer numberOfFish;
    private Member member;
    private Fish fish;
    private Competition competition;
}
