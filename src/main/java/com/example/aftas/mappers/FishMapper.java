package com.example.aftas.mappers;

import com.example.aftas.VMs.request.FishRequest;
import com.example.aftas.VMs.response.FishResponse;
import com.example.aftas.entities.Fish;

public class FishMapper {

    public static Fish mapFishRequestToFish(FishRequest fishRequest) {
        return new Fish().builder()
                .name(fishRequest.getName())
                .averageWeight(fishRequest.getAverageWeight())
                .level(fishRequest.getLevel())
                .build();
    }

    public static FishResponse mapFishToFishResponse(Fish fish) {
        return new FishResponse().builder()
                .name(fish.getName())
                .averageWeight(fish.getAverageWeight())
                .level(fish.getLevel())
                .build();
    }
}
