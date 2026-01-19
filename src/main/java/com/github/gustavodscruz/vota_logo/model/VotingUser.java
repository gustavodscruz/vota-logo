package com.github.gustavodscruz.vota_logo.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Table
@Entity
public class VotingUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "voting_user_id")
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;

    private String password; 
    @Enumerated(value = EnumType.STRING)
    private UserPermissionsType type;
    @CreatedDate
    private LocalDateTime signInDate;
    private Boolean isActive;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "users_roles", 
        joinColumns = @JoinColumn(name = "voting_user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;

}
