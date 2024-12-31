package ru.clevertec.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import ru.clevertec.domain.Role;

@Getter
@Setter
public class UserRegisterRequest {
    @NotBlank(message = "Имя пользователя не может быть пустым")
    @Size(min = 5, message = "Логин должен состоять минимум из 5 символов")
    private String username;

    @NotBlank(message = "Пароль не может быть пустым")
    @Size(min = 6, message = "Пароль должен состоять минимум из 6 символов")
    private String password;

    @NotBlank(message = "Роль не может быть пустой")
    private String role;
}
