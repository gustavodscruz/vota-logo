package com.github.gustavodscruz.vota_logo.service;

import com.github.gustavodscruz.vota_logo.model.Voting;
import com.github.gustavodscruz.vota_logo.model.VotingUser;
import com.github.gustavodscruz.vota_logo.model.dto.VoteRequest;
import com.github.gustavodscruz.vota_logo.repository.VotingRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VotingService {
    private final VotingRepository votingRepository;

    public Voting save(VoteRequest request, VotingUser user) {
        Voting votingReq = new Voting(request, user);
        return this.votingRepository.save(votingReq);
    }

    public Voting update(VoteRequest request, VotingUser user, Long votingId) {
        Voting storedVoting = this.findById(votingId);
        if (!(storedVoting.getCreator().equals(user))) {
            throw new IllegalAccessError("You are not authorized to do this!");
        }

        BeanUtils.copyProperties(request, storedVoting, "id", "createdAt", "creator");
        return this.votingRepository.save(storedVoting);
    }

    public List<Voting> findAll() {
        return this.votingRepository.findAll();
    }

    public Voting findById(Long id) {
        return this.votingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Voting session not exists anymore!"));
    }

    public boolean delete(Long id) {
        Voting voting = this.findById(id);
        this.votingRepository.delete(voting);
        return true;
    }
}
