package com.example.aftas.controller;

import com.example.aftas.VMs.request.CompetitionRequest;
import com.example.aftas.VMs.request.RegisterRequest;
import com.example.aftas.entities.Competition;
import com.example.aftas.mappers.CompetitionMapper;
import com.example.aftas.response.ResponseMessage;
import com.example.aftas.service.CompetitionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competition")
@RequiredArgsConstructor
public class CompetitionController {

    private final CompetitionService competitionService;

    @GetMapping("")
    public ResponseEntity getCompetitions() {
        List<Competition> competitions = competitionService.getCompetitions();
        if (competitions.isEmpty()) {
            return ResponseMessage.notFound("Competitions Not Found");
        } else {
            return ResponseMessage.ok("Success", competitions);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getCompetitionById(@PathVariable Long id) {
        Competition competition = competitionService.getCompetitionById(id);
        if (competition == null) {
            return ResponseMessage.notFound("Competition Not Found");
        } else {
            return ResponseMessage.ok("Success", competition);
        }
    }

    @PostMapping("")
    public ResponseEntity addCompetition(@RequestBody @Valid CompetitionRequest competitionRequest) {
        Competition competition = CompetitionMapper.mapCompetitionRequestToCompetition(competitionRequest);
        Competition competition1 = competitionService.addCompetition(competition);
        if(competition1 == null) {
            return ResponseMessage.badRequest("Failed To Create Competition");
        } else {
            return ResponseMessage.created("Competition Created Successfully", competition1);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCompetition(@RequestBody @Valid CompetitionRequest competitionRequest, @PathVariable Long id) {
        Competition competition = CompetitionMapper.mapCompetitionRequestToCompetition(competitionRequest);
        Competition competition1 = competitionService.updateCompetition(competition, id);
        if (competition1 == null) {
            return ResponseMessage.badRequest("Competition Not Updated");
        } else {
            return ResponseMessage.created("Competition Updated Successfully", competition1);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteCompetition(@PathVariable Long id) {
        Competition competition = competitionService.getCompetitionById(id);
        if (competition == null) {
            return ResponseMessage.notFound("Competition Not Found");
        } else {
            competitionService.deleteCompetition(id);
            return ResponseMessage.ok("Competition Deleted Successfully", competition);
        }
    }
}
