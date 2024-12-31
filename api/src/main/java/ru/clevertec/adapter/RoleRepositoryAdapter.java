package ru.clevertec.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.clevertec.domain.Role;
import ru.clevertec.entity.RoleEntity;
import ru.clevertec.port.RoleRepositoryPort;
import ru.clevertec.repository.RoleRepository;

@Component
@RequiredArgsConstructor
public class RoleRepositoryAdapter implements RoleRepositoryPort {
    private final RoleRepository roleRepository;

    @Override
    public Role findByName(String name) {
        RoleEntity roleEntity = roleRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("Неизвестная роль"));
        return new Role(roleEntity.getId(), roleEntity.getName());
    }
}
