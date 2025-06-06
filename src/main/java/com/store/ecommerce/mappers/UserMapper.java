package com.store.ecommerce.mappers;

import com.store.ecommerce.dtos.UserDto;
import com.store.ecommerce.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
}
