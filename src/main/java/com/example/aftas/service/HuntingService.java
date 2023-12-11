package com.example.aftas.service;

import com.example.aftas.entities.Hunting;

public interface HuntingService {
    Hunting getHuntingById(Long id);

    Hunting addHunting(Hunting hunting);

    Hunting updateHunting(Hunting hunting, Long id);

    void deleteHunting(Long id);
}
