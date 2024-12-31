package ru.clevertec.port;

import ru.clevertec.domain.User;

public interface UserRepositoryPort {
    User findByUsername(String username);

    User save(User user);

    boolean existsByUsername(String username);
}
