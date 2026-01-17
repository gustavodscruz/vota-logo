package com.github.gustavodscruz.vota_logo.repository;

import com.github.gustavodscruz.vota_logo.model.Voting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotingRepository extends JpaRepository<Voting, Long> {
}
