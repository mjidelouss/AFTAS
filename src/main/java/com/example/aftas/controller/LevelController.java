package com.example.aftas.controller;

import com.example.aftas.entities.Level;
import com.example.aftas.response.ResponseMessage;
import com.example.aftas.service.LevelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/level")
@RequiredArgsConstructor
public class LevelController {

    private final LevelService levelService;

    @GetMapping("/{id}")
    public ResponseEntity getLevelById(@PathVariable Long id) {
        Level level = levelService.getLevelById(id);
        if (level == null) {
            return ResponseMessage.notFound("Level Not Found");
        } else {
            return ResponseMessage.ok("Success", level);
        }
    }

    @PostMapping("")
    public ResponseEntity addLevel(@RequestBody @Valid Level level) {
        Level level1 = levelService.addLevel(level);
        if(level1 == null) {
            return ResponseMessage.badRequest("Failed To Create Level");
        } else {
            return ResponseMessage.created("Level Created Successfully", level1);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateLevel(@RequestBody Level level, @PathVariable Long id) {
        Level level1 = levelService.updateLevel(level, id);
        if (level1 == null) {
            return ResponseMessage.badRequest("Level Not Updated");
        } else {
            return ResponseMessage.created("Level Updated Successfully", level1);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteLevel(@PathVariable Long id) {
        Level level = levelService.getLevelById(id);
        if (level == null) {
            return ResponseMessage.notFound("Level Not Found");
        } else {
            levelService.deleteLevel(id);
            return ResponseMessage.ok("Level Deleted Successfully", level);
        }
    }
}
