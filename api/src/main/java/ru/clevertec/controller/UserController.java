package ru.clevertec.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.clevertec.api.ApiResponse;
import ru.clevertec.dto.UserDetailsDto;
import ru.clevertec.dto.UserLoginRequest;
import ru.clevertec.dto.UserRegisterRequest;
import ru.clevertec.service.UserService;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Validated
public class UserController {
    private final UserService userService;

    @GetMapping("/{username}")
    public ResponseEntity<ApiResponse<UserDetailsDto>> getUserByUsername(@PathVariable String username) {
        return ResponseEntity.ok(ApiResponse.<UserDetailsDto>builder()
                .data(userService.loadUserByUsername(username))
                .status(true)
                .message("Пользователь получен")
                .build());
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<String>> register(@Valid @RequestBody UserRegisterRequest request) {
        userService.registerUser(request);
        return ResponseEntity.ok(ApiResponse.<String>builder()
                .message("Пользователь успешно зарегистрирован")
                .status(true)
                .build());
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<String>> login(@RequestBody UserLoginRequest request) {
        String token = userService.authenticate(request.getUsername(), request.getPassword());
        return ResponseEntity.ok(ApiResponse.<String>builder()
                .data(token)
                .message("Вход успешен")
                .status(true)
                .build());
    }
}
