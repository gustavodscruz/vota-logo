package com.github.gustavodscruz.vota_logo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Map;

import com.github.gustavodscruz.vota_logo.utils.JsonMapConverter;

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
