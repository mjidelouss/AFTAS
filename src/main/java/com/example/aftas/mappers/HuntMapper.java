package com.example.aftas.mappers;

import com.example.aftas.VMs.request.HuntingRequest;
import com.example.aftas.VMs.response.HuntingResponse;
import com.example.aftas.entities.Hunt;

public class HuntMapper {

    public static Hunt mapHuntRequestToHunt(HuntingRequest huntingRequest) {
        return new Hunt().builder()
                .numberOfFish(huntingRequest.getNumberOfFish())
                .fish(huntingRequest.getFish())
                .member(huntingRequest.getMember())
                .competition(huntingRequest.getCompetition())
                .build();
    }

    public static HuntingResponse mapHuntToHuntResponse(Hunt hunt) {
        return new HuntingResponse().builder()
                .numberOfFish(hunt.getNumberOfFish())
                .member(hunt.getMember())
                .competition(hunt.getCompetition())
                .fish(hunt.getFish())
                .build();
    }
}
