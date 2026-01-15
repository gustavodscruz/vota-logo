package com.github.gustavodscruz.vota_logo.model;

import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Entity
@Table
public class Vote {
    private Long id;
    @ManyToOne
    @JoinColumn(name = "voting_id")
    private Voting voting;

    @ManyToOne
    private VotingOption option;

    private VotingUser user;

    private String sessionId;

    private String ipAddress;

    @CreatedDate
    private LocalDateTime voteDate;

    private Integer importance;

    private String justification;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private Map<String, Object> metadata;

}
