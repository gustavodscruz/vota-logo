package com.github.gustavodscruz.vota_logo.model;

import jakarta.persistence.*;
import lombok.Data;
import utils.JsonMapConverter;

import java.util.Map;

@Data
@Table
@Entity
public class VotingRule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Voting voting;

    private String type;

    @Convert(converter = JsonMapConverter.class)
    @Column(columnDefinition = "jsonb")
    private Map<String, Object> parameters;
}
