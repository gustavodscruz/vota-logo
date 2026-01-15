package com.github.gustavodscruz.vota_logo.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@Table
@Entity
public class VotingUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private UserPermissionsType type;
    @CreatedDate
    private LocalDateTime signInDate;
    private Boolean isActive;

}
