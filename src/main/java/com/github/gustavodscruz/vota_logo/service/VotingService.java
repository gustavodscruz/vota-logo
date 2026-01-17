package com.github.gustavodscruz.vota_logo.service;

import com.github.gustavodscruz.vota_logo.model.Voting;
import com.github.gustavodscruz.vota_logo.repository.VotingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VotingService {
    private final VotingRepository votingRepository;

    public Voting save(Voting request){
        return this.votingRepository.save(request);
    }

}
