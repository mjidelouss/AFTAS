package com.example.aftas.mappers;

import com.example.aftas.VMs.request.RankRequest;
import com.example.aftas.VMs.response.RankResponse;
import com.example.aftas.entities.Rank;

public class RankMapper {

    public static Rank mapRankRequestToRank(RankRequest rankRequest) {
        return new Rank().builder()
                .rank(rankRequest.getRank())
                .score(rankRequest.getScore())
                .member(rankRequest.getMember())
                .competition(rankRequest.getCompetition())
                .build();
    }

    public static RankResponse mapRankToRankResponse(Rank rank) {
        return new RankResponse().builder()
                .rank(rank.getRank())
                .competition(rank.getCompetition())
                .member(rank.getMember())
                .score(rank.getScore())
                .build();
    }
}
