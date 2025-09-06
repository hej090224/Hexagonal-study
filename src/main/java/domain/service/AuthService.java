package domain.service;

import domain.port.in.AuthUseCase;
import domain.model.UserAccount;
import domain.port.out.UserRepository;

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
