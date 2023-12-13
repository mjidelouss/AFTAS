package com.example.aftas.mappers;

import com.example.aftas.VMs.request.LevelRequest;
import com.example.aftas.VMs.response.LevelResponse;
import com.example.aftas.entities.Level;

public class LevelMapper {

    public static Level mapLevelRequestToMapper(LevelRequest levelRequest) {
        return Level.builder()
                .level(levelRequest.getLevel())
                .points(levelRequest.getPoints())
                .description(levelRequest.getDescription())
                .build();
    }

    public static LevelResponse mapLevelToLevelResponse(Level level) {
        return LevelResponse.builder()
                .level(level.getLevel())
                .points(level.getPoints())
                .description(level.getDescription())
                .build();
    }
}
