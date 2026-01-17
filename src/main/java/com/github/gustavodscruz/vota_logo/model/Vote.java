package com.github.gustavodscruz.vota_logo.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import utils.JsonMapConverter;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Entity
@Table
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "voting_id")
    private Voting voting;

    @ManyToOne
    private VotingOption option;

    @ManyToOne
    private VotingUser user;

    private String sessionId;

    private String ipAddress;

    @CreatedDate
    private LocalDateTime voteDate;

    private Integer importance;

    private String justification;

    @Convert(converter = JsonMapConverter.class)
    @Column(columnDefinition = "jsonb")
    private Map<String, Object> metadata;

}
