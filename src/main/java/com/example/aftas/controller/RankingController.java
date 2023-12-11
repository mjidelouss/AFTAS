package com.example.aftas.controller;
import com.example.aftas.entities.Fish;
import com.example.aftas.entities.Ranking;
import com.example.aftas.response.ResponseMessage;
import com.example.aftas.service.RankingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ranking")
@RequiredArgsConstructor
public class RankingController {

    private final RankingService rankingService;

    @GetMapping("")
    public ResponseEntity getRankings() {
        List<Ranking> rankings = rankingService.getRankings();
        if (rankings.isEmpty()) {
            return ResponseMessage.notFound("Rankings Not Found");
        } else {
            return ResponseMessage.ok("Success", rankings);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getRankingById(@PathVariable Long id) {
        Ranking ranking = rankingService.getRankingById(id);
        if (ranking == null) {
            return ResponseMessage.notFound("Ranking Not Found");
        } else {
            return ResponseMessage.ok("Success", ranking);
        }
    }

    @PostMapping("")
    public ResponseEntity addRanking(@RequestBody @Valid Ranking ranking) {
        Ranking ranking1 = rankingService.addRanking(ranking);
        if(ranking1 == null) {
            return ResponseMessage.badRequest("Failed To Create Ranking");
        } else {
            return ResponseMessage.created("Ranking Created Successfully", ranking1);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateRanking(@RequestBody Ranking ranking, @PathVariable Long id) {
        Ranking ranking1 = rankingService.updateRanking(ranking, id);
        if (ranking1 == null) {
            return ResponseMessage.badRequest("Ranking Not Updated");
        } else {
            return ResponseMessage.created("Ranking Updated Successfully", ranking1);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteRanking(@PathVariable Long id) {
        Ranking ranking = rankingService.getRankingById(id);
        if (ranking == null) {
            return ResponseMessage.notFound("Ranking Not Found");
        } else {
            rankingService.deleteRanking(id);
            return ResponseMessage.ok("Ranking Deleted Successfully", ranking);
        }
    }
}
