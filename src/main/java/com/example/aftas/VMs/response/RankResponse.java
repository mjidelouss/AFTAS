package com.example.aftas.VMs.response;

import com.example.aftas.entities.Competition;
import com.example.aftas.entities.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RankResponse {
    private Integer rank;
    private Integer score;
    private Member member;
    private Competition competition;
}
