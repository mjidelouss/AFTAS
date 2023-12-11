package com.example.aftas.controller;
import com.example.aftas.entities.Rank;
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
        List<Rank> ranks = rankingService.getRankings();
        if (ranks.isEmpty()) {
            return ResponseMessage.notFound("Rankings Not Found");
        } else {
            return ResponseMessage.ok("Success", ranks);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getRankingById(@PathVariable Long id) {
        Rank rank = rankingService.getRankingById(id);
        if (rank == null) {
            return ResponseMessage.notFound("Ranking Not Found");
        } else {
            return ResponseMessage.ok("Success", rank);
        }
    }

    @PostMapping("")
    public ResponseEntity addRanking(@RequestBody @Valid Rank rank) {
        Rank rank1 = rankingService.addRanking(rank);
        if(rank1 == null) {
            return ResponseMessage.badRequest("Failed To Create Ranking");
        } else {
            return ResponseMessage.created("Ranking Created Successfully", rank1);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateRanking(@RequestBody Rank rank, @PathVariable Long id) {
        Rank rank1 = rankingService.updateRanking(rank, id);
        if (rank1 == null) {
            return ResponseMessage.badRequest("Ranking Not Updated");
        } else {
            return ResponseMessage.created("Ranking Updated Successfully", rank1);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteRanking(@PathVariable Long id) {
        Rank rank = rankingService.getRankingById(id);
        if (rank == null) {
            return ResponseMessage.notFound("Ranking Not Found");
        } else {
            rankingService.deleteRanking(id);
            return ResponseMessage.ok("Ranking Deleted Successfully", rank);
        }
    }
}
