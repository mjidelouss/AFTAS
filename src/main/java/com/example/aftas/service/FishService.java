package com.example.aftas.service;

import com.example.aftas.entities.Fish;

public interface FishService {

    Fish getFishById(Long id);

    Fish addFish(Fish fish);

    Fish updateFish(Fish fish, Long id);

    void deleteFish(Long id);
}
