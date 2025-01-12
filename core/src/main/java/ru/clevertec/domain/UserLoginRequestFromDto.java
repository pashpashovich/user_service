package ru.clevertec.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginRequestFromDto {
    private String username;
    private String password;
}
