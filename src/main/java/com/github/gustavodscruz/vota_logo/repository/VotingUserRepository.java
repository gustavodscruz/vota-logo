package com.github.gustavodscruz.vota_logo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.gustavodscruz.vota_logo.model.VotingUser;

public interface VotingUserRepository extends JpaRepository<VotingUser, Long> {
    Optional<VotingUser> findByEmail(String email);
}
