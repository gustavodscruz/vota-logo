package com.github.gustavodscruz.vota_logo.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Table
@Entity
public class Voting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String description;

    @Enumerated(value = EnumType.STRING)
    private VotingType type;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @Enumerated(value = EnumType.STRING)
    private VotingVisibility visibility;

    private Integer maxVotesPerUser = 1;

    private Boolean permitsAnonymous = true;

    private Boolean publicResult = true;

    @ManyToOne
    private VotingUser creator;

    @CreatedDate
    private LocalDateTime createdAt;

    private List<String> tags;

}
