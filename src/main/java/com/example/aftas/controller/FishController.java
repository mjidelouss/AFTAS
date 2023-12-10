package com.example.aftas.controller;

import com.example.aftas.entities.Fish;
import com.example.aftas.entities.Member;
import com.example.aftas.response.ResponseMessage;
import com.example.aftas.service.FishService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fish")
@RequiredArgsConstructor
public class FishController {
    private final FishService fishService;

    @GetMapping("/{id}")
    public ResponseEntity getFishById(@PathVariable Long id) {
        Fish fish = fishService.getFishById(id);
        if (fish == null) {
            return ResponseMessage.notFound("Fish Not Found");
        } else {
            return ResponseMessage.ok("Success", fish);
        }
    }

    @PostMapping("")
    public ResponseEntity addFish(@RequestBody @Valid Fish fish) {
        Fish fish1 = fishService.addFish(fish);
        if(fish1 == null) {
            return ResponseMessage.badRequest("Failed To Add Fish");
        } else {
            return ResponseMessage.created("Fish Added Successfully", fish1);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateFish(@RequestBody Fish fish, @PathVariable Long id) {
        Fish fish1 = fishService.updateFish(fish, id);
        if (fish1 == null) {
            return ResponseMessage.badRequest("Fish Not Updated");
        } else {
            return ResponseMessage.created("Fish Updated Successfully", fish1);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteFish(@PathVariable Long id) {
        Fish fish = fishService.getFishById(id);
        if (fish == null) {
            return ResponseMessage.notFound("Fish Not Found");
        } else {
            fishService.deleteFish(id);
            return ResponseMessage.ok("Fish Deleted Successfully", fish);
        }
    }
}
