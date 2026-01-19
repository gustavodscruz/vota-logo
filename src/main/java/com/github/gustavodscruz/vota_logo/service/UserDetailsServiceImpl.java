package com.github.gustavodscruz.vota_logo.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.github.gustavodscruz.vota_logo.model.UserDetailsImpl;
import com.github.gustavodscruz.vota_logo.model.VotingUser;
import com.github.gustavodscruz.vota_logo.repository.VotingUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final VotingUserRepository votingUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        VotingUser votingUser = this.votingUserRepository.findByEmail(username).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return new UserDetailsImpl(votingUser);
    }
    
}
