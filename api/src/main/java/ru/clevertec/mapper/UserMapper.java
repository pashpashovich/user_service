package ru.clevertec.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.clevertec.domain.User;
import ru.clevertec.entity.RoleEntity;
import ru.clevertec.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toDomain(UserEntity userEntity);

    UserEntity toEntity(User user);

}
