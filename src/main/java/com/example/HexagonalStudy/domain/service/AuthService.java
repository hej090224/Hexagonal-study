package com.example.HexagonalStudy.domain.service;

import com.example.HexagonalStudy.domain.port.in.AuthUseCase;
import com.example.HexagonalStudy.domain.model.UserAccount;
import com.example.HexagonalStudy.domain.port.out.UserRepository;

import java.util.Optional;

public class AuthService implements AuthUseCase {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<UserAccount> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserAccount register(UserAccount user) {
        return userRepository.save(user);
    }
}
