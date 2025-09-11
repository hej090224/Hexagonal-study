package com.example.HexagonalStudy.adapter.out.persistence;

import com.example.HexagonalStudy.domain.port.out.UserRepository;
import com.example.HexagonalStudy.domain.model.UserAccount;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaUserRepositoryAdapter implements UserRepository {

    private final SpringDataUserRepository repo;

    public JpaUserRepositoryAdapter(SpringDataUserRepository repo) {
        this.repo = repo;
    }

    @Override
    public  Optional<UserAccount> findByUsername(String username) {
        return repo.findByUsername(username).map(JpaUserEntity::toDomain);
    }

    @Override
    public UserAccount save(UserAccount user) {
        return repo.save(JpaUserEntity.fromDomain(user)).toDomain();
    }
}
