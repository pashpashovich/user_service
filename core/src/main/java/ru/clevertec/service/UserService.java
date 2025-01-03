package ru.clevertec.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.clevertec.domain.Role;
import ru.clevertec.domain.User;
import ru.clevertec.dto.UserDetailsDto;
import ru.clevertec.dto.UserRegisterRequest;
import ru.clevertec.port.RoleRepositoryPort;
import ru.clevertec.port.UserRepositoryPort;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepositoryPort userRepository;
    private final RoleRepositoryPort roleRepositoryPort;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public void registerUser(UserRegisterRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new IllegalArgumentException("Такое имя пользователя уже существует");
        }
        Role role = roleRepositoryPort.findByName(request.getRole());
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(role);
        userRepository.save(user);
    }

    public String authenticate(String username, String rawPassword) {
        User user = userRepository.findByUsername(username);
        if (!passwordEncoder.matches(rawPassword, user.getPassword())) {
            throw new BadCredentialsException("Неверный логин или пароль");
        }
        return jwtService.generateToken(user.getUsername(), user.getRole().getName());
    }

    public UserDetailsDto loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        return new UserDetailsDto(user.getUsername(), List.of(user.getRole().getName()));
    }
}
