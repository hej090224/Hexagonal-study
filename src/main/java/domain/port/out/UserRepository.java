package domain.port.out;

import domain.model.UserAccount;

import java.util.Optional;

public interface UserRepository {
    Optional<UserAccount> findByUsername(String username);
    UserAccount save(UserAccount user);
}
