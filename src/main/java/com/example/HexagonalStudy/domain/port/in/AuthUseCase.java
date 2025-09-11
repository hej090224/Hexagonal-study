package com.example.HexagonalStudy.domain.port.in;

import com.example.HexagonalStudy.domain.model.UserAccount;

import java.util.Optional;

public interface AuthUseCase {
    Optional<UserAccount> findByUsername(String username);
    UserAccount register(UserAccount user);
}
