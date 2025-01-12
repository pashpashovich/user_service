package ru.clevertec.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.clevertec.domain.User;
import ru.clevertec.exception.NotFoundException;
import ru.clevertec.mapper.UserMapper;
import ru.clevertec.port.UserRepositoryPort;
import ru.clevertec.repository.UserRepository;

@Component
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepositoryPort {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public User findByUsername(String username) {
        return userMapper.toDomain(userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("Пользователь с данным логином не найден")));
    }

    @Override
    public User save(User user) {
        return userMapper.toDomain(userRepository.save(userMapper.toEntity(user)));
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }
}

