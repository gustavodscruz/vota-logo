package com.github.gustavodscruz.vota_logo.model;

import jakarta.persistence.*;
import lombok.Data;

import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.CreatedDate;

import com.github.gustavodscruz.vota_logo.model.dto.VoteRequest;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Table
@Entity
public class Voting {

    public Voting(VoteRequest request) {
        BeanUtils.copyProperties(request, this);
        this.createdAt = LocalDateTime.now();
    }

    public Voting(VoteRequest request, VotingUser creator) {
        BeanUtils.copyProperties(request, this);
        this.createdAt = LocalDateTime.now();
        this.creator = creator;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String description;

    @Enumerated(value = EnumType.STRING)
    private VotingType type;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private VotingStatus status;

    @Enumerated(value = EnumType.STRING)
    private VotingVisibility visibility;

    private Integer maxVotesPerUser = 1;

    private Boolean permitsAnonymous = true;

    private Boolean publicResult = true;

    @ManyToOne
    private VotingUser creator;

    @CreatedDate
    private LocalDateTime createdAt;

    @ElementCollection
    @CollectionTable(name = "voting_tags", joinColumns = @JoinColumn(name = "voting_id"))
    @Column(name = "tag")
    private List<String> tags;

}
