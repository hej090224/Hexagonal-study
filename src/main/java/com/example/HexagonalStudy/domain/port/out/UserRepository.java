package com.example.HexagonalStudy.domain.port.out;

import com.example.HexagonalStudy.domain.model.UserAccount;

import java.util.Optional;

public interface UserRepository {
    Optional<UserAccount> findByUsername(String username);
    UserAccount save(UserAccount user);
}
