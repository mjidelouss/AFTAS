package com.example.aftas.controller;
import com.example.aftas.VMs.request.RankRequest;
import com.example.aftas.entities.Rank;
import com.example.aftas.mappers.RankMapper;
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

    @PostMapping("")
    public ResponseEntity addRanking(@RequestBody @Valid RankRequest rankRequest) {
        Rank rank = RankMapper.mapRankRequestToRank(rankRequest);
        Rank rank1 = rankingService.addRanking(rank);
        if(rank1 == null) {
            return ResponseMessage.badRequest("Failed To Create Ranking");
        } else {
            return ResponseMessage.created("Ranking Created Successfully", rank1);
        }
    }
}
