package ru.clevertec.mapper;

import org.mapstruct.Mapper;
import ru.clevertec.domain.User;
import ru.clevertec.domain.UserDetailsFromDto;
import ru.clevertec.domain.UserRegisterRequestFromDto;
import ru.clevertec.dto.UserDetailsDto;
import ru.clevertec.dto.UserRegisterRequest;
import ru.clevertec.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toDomain(UserEntity userEntity);

    UserEntity toEntity(User user);

    UserDetailsDto toDto(UserDetailsFromDto userDetailsFromDto);

    UserRegisterRequestFromDto toUserRegister(UserRegisterRequest userRegisterRequest);
}
