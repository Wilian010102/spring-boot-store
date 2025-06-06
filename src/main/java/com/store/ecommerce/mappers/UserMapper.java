package com.store.ecommerce.mappers;

import com.store.ecommerce.dtos.RegisterUserRequest;
import com.store.ecommerce.dtos.UpdateUserRequest;
import com.store.ecommerce.dtos.UserDto;
import com.store.ecommerce.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(RegisterUserRequest request);
    void update(UpdateUserRequest request, @MappingTarget User user);
}
