package domain.port.in;

import domain.model.UserAccount;

import java.util.Optional;

public interface AuthUseCase {
    Optional<UserAccount> findByUsername(String username);
    UserAccount register(UserAccount user);
}
