package com.example.aftas.service.Impl;

import com.example.aftas.entities.Hunting;
import com.example.aftas.repository.HuntingRepository;
import com.example.aftas.service.HuntingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HuntingServiceImpl implements HuntingService {
    private final HuntingRepository huntingRepository;

    @Override
    public Hunting getHuntingById(Long id) {
        return huntingRepository.findById(id).orElse(null);
    }

    @Override
    public Hunting addHunting(Hunting hunting) {
        return huntingRepository.save(hunting);
    }

    @Override
    public Hunting updateHunting(Hunting hunting, Long id) {
        Hunting existingHunting = getHuntingById(id);
        existingHunting.setNumberOfFish(hunting.getNumberOfFish());
        return huntingRepository.save(existingHunting);
    }

    @Override
    public void deleteHunting(Long id) {
        huntingRepository.deleteById(id);
    }
}
