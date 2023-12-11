package com.example.aftas.service.Impl;

import com.example.aftas.entities.Level;
import com.example.aftas.repository.LevelRepository;
import com.example.aftas.service.LevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LevelServiceImpl implements LevelService {

    private final LevelRepository levelRepository;
    @Override
    public Level getLevelById(Long id) {
        return levelRepository.findById(id).orElse(null);
    }

    @Override
    public Level addLevel(Level level) {
        return levelRepository.save(level);
    }

    @Override
    public Level updateLevel(Level level, Long id) {
        Level existingLevel = getLevelById(id);
        existingLevel.setLevel(level.getLevel());
        existingLevel.setDescription(level.getDescription());
        existingLevel.setPoints(level.getPoints());
        return levelRepository.save(existingLevel);
    }

    @Override
    public void deleteLevel(Long id) {
        levelRepository.deleteById(id);
    }
}
