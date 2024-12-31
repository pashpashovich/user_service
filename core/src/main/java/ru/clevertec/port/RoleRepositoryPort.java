package ru.clevertec.port;

import org.springframework.stereotype.Component;
import ru.clevertec.domain.Role;

import java.util.Optional;

@Component
public interface RoleRepositoryPort {
    Role findByName(String name);
}
