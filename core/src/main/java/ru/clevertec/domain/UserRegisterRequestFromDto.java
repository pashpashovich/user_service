package ru.clevertec.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterRequestFromDto {
    private String username;
    private String password;
    private String role;
}
