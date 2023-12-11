package com.example.aftas.service;

import com.example.aftas.entities.Level;

public interface LevelService {
    Level getLevelById(Long id);

    Level addLevel(Level level);

    Level updateLevel(Level level, Long id);

    void deleteLevel(Long id);
}
