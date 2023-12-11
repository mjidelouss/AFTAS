package com.example.aftas.controller;

import com.example.aftas.entities.Fish;
import com.example.aftas.entities.Hunting;
import com.example.aftas.response.ResponseMessage;
import com.example.aftas.service.HuntingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hunting")
@RequiredArgsConstructor
public class HuntingController {
    private final HuntingService huntingService;

    @GetMapping("")
    public ResponseEntity getHuntings() {
        List<Hunting> huntings = huntingService.getHuntings();
        if (huntings.isEmpty()) {
            return ResponseMessage.notFound("Huntings Not Found");
        } else {
            return ResponseMessage.ok("Success", huntings);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getHuntingById(@PathVariable Long id) {
        Hunting hunting = huntingService.getHuntingById(id);
        if (hunting == null) {
            return ResponseMessage.notFound("Hunting Not Found");
        } else {
            return ResponseMessage.ok("Success", hunting);
        }
    }

    @PostMapping("")
    public ResponseEntity addHunting(@RequestBody @Valid Hunting hunting) {
        Hunting hunting1 = huntingService.addHunting(hunting);
        if(hunting1 == null) {
            return ResponseMessage.badRequest("Failed To Create Hunting");
        } else {
            return ResponseMessage.created("Hunting Created Successfully", hunting1);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateHunting(@RequestBody Hunting hunting, @PathVariable Long id) {
        Hunting hunting1 = huntingService.updateHunting(hunting, id);
        if (hunting1 == null) {
            return ResponseMessage.badRequest("Hunting Not Updated");
        } else {
            return ResponseMessage.created("Hunting Updated Successfully", hunting1);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteHunting(@PathVariable Long id) {
        Hunting hunting = huntingService.getHuntingById(id);
        if (hunting == null) {
            return ResponseMessage.notFound("Hunting Not Found");
        } else {
            huntingService.deleteHunting(id);
            return ResponseMessage.ok("Hunting Deleted Successfully", hunting);
        }
    }
}
