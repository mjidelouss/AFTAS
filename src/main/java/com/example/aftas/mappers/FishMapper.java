package com.example.aftas.mappers;

import com.example.aftas.VMs.request.FishRequest;
import com.example.aftas.VMs.response.FishResponse;
import com.example.aftas.entities.Fish;
import com.example.aftas.service.LevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FishMapper {

    private final LevelService levelService;

    public Fish mapFishRequestToFish(FishRequest fishRequest) {
        return Fish.builder()
                .name(fishRequest.getName())
                .averageWeight(fishRequest.getAverageWeight())
                .level(levelService.getLevelByLevel(fishRequest.getLevel()))
                .build();
    }

    public static FishResponse mapFishToFishResponse(Fish fish) {
        return FishResponse.builder()
                .name(fish.getName())
                .averageWeight(fish.getAverageWeight())
                .level(fish.getLevel())
                .build();
    }
}
