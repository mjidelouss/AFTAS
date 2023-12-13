package com.example.aftas.mappers;

import com.example.aftas.VMs.request.RankRequest;
import com.example.aftas.VMs.response.RankResponse;
import com.example.aftas.entities.Rank;
import com.example.aftas.entities.RankId;

public class RankMapper {

    public static Rank mapRankRequestToRank(RankRequest rankRequest) {
        return  Rank.builder()
                .id(RankId.builder()
                        .competitionId(rankRequest.getCompetition().getId())
                        .memberId(rankRequest.getMember().getId())
                    .build())
                .rank(rankRequest.getRank())
                .score(rankRequest.getScore())
                .member(rankRequest.getMember())
                .competition(rankRequest.getCompetition())
                .build();
    }

    public static RankResponse mapRankToRankResponse(Rank rank) {
        return RankResponse.builder()
                .rank(rank.getRank())
                .competition(rank.getCompetition())
                .member(rank.getMember())
                .score(rank.getScore())
                .build();
    }
}
