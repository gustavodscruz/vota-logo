package com.github.gustavodscruz.vota_logo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.gustavodscruz.vota_logo.model.Voting;
import com.github.gustavodscruz.vota_logo.service.VotingService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/voting")
@RequiredArgsConstructor
@Log4j2
public class VotingController {
    private final VotingService votingService;

    @GetMapping
    public ResponseEntity<List<Voting>> findAll() {
        var votings = this.votingService.findAll();

        log.info("Votings: {}", votings);
        return ResponseEntity.ok(votings);
    }

}
