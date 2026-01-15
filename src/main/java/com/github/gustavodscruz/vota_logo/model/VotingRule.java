package com.github.gustavodscruz.vota_logo.model;

import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;

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

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private Map<String, Object> parameters;
}
