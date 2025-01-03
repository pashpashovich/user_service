package ru.clevertec.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserDetailsDto {
    private String username;
    private List<String> authorities;

}
