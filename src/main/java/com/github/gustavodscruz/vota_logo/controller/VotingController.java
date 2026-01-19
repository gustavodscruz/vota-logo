package com.github.gustavodscruz.vota_logo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.gustavodscruz.vota_logo.exception.FieldException;
import com.github.gustavodscruz.vota_logo.model.UserDetailsImpl;
import com.github.gustavodscruz.vota_logo.model.Voting;
import com.github.gustavodscruz.vota_logo.model.dto.VoteRequest;
import com.github.gustavodscruz.vota_logo.service.VotingService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("voting")
@RequiredArgsConstructor
@Log4j2
public class VotingController {
    private final VotingService votingService;

    @GetMapping
    public ResponseEntity<List<Voting>> findAll() {
        return ResponseEntity.ok(this.votingService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Voting> findById(@PathVariable Long id) {
        return ResponseEntity.ok(this.votingService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Voting> save(AuthenticationPrincipal principal, @Valid @RequestBody VoteRequest request,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new FieldException("Error on vote request", bindingResult);
        }

        UserDetailsImpl userDetailsImpl = ((UserDetailsImpl) principal);
        return ResponseEntity.ok(this.votingService.save(request, userDetailsImpl.getUser()));
    }

}
