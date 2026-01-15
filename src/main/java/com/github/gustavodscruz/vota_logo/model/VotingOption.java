package com.github.gustavodscruz.vota_logo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table
@Entity
public class VotingOption {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String text;
    private String description;
    private String imageUrl;
    private Integer order = 0;
    private Boolean isActive = true;
}
