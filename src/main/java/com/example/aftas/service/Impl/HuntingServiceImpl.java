package com.example.aftas.service.Impl;

import com.example.aftas.entities.Fish;
import com.example.aftas.entities.Hunt;
import com.example.aftas.repository.HuntingRepository;
import com.example.aftas.service.HuntingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HuntingServiceImpl implements HuntingService {

    private final HuntingRepository huntingRepository;

    @Override
    public Hunt getHuntingById(Long id) {
        return huntingRepository.findById(id).orElse(null);
    }

    @Override
    public Hunt addHunting(Hunt hunt) {
        String fishName = hunt.getFish().getName();
        Hunt existingHunt = huntingRepository.findByFish_NameAndMember_Id(fishName, hunt.getMember().getId());

        if (existingHunt != null) {
            existingHunt.setNumberOfFish(existingHunt.getNumberOfFish() + hunt.getNumberOfFish());
            return huntingRepository.save(existingHunt);
        } else {
            return huntingRepository.save(hunt);
        }
    }

    @Override
    public Hunt updateHunting(Hunt hunt, Long id) {
        Hunt existingHunt = getHuntingById(id);
        existingHunt.setNumberOfFish(hunt.getNumberOfFish());
        return huntingRepository.save(existingHunt);
    }

    @Override
    public void deleteHunting(Long id) {
        huntingRepository.deleteById(id);
    }

    @Override
    public List<Hunt> getHuntings() {
        return huntingRepository.findAll();
    }

    public void validateFishWeight(Hunt hunt, Double huntedWeight) {
        if (huntedWeight < hunt.getFish().getAverageWeight()) {
            throw new IllegalArgumentException("Hunted weight must be equal or greater than average weight");
        }
    }
}
