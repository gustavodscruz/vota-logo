package com.github.gustavodscruz.vota_logo.model.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.github.gustavodscruz.vota_logo.model.VotingStatus;
import com.github.gustavodscruz.vota_logo.model.VotingType;
import com.github.gustavodscruz.vota_logo.model.VotingVisibility;

public record VoteRequest(
    String title, 
    String description, 
    VotingType type,
    LocalDateTime startDate,
    LocalDateTime endDate,
    VotingStatus status,
    VotingVisibility visibility,
    Integer maxVotesPerUser,
    Boolean permitsAnonymous,
    Boolean publicResult,
    List<String> tags
) {

}
