package com.store.ecommerce.controllers;

import com.store.ecommerce.dtos.RegisterUserRequest;
import com.store.ecommerce.dtos.UserDto;
import com.store.ecommerce.mappers.UserMapper;
import com.store.ecommerce.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;

@RestController
@AllArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody RegisterUserRequest request,
                                                UriComponentsBuilder uriBuilder) {
        var user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Hash password dengan BCrypt
        userRepository.save(user);

        var userDto = userMapper.toDto(user);
        var uri = uriBuilder
                .path("/users/{id}")
                .buildAndExpand(userDto.getId())
                .toUri();

        return ResponseEntity.created(uri).body(userDto);
    }
}
