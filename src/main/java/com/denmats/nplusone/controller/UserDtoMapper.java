package com.denmats.nplusone.controller;

import com.denmats.nplusone.controller.dto.UserDto;
import com.denmats.nplusone.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserDtoMapper {
    private UserDtoMapper() {
    }

    public static List<UserDto> mapToUserDtos(List<User> users) {
        return users.stream()
                .map(UserDtoMapper::mapToUserDto)
                .collect(Collectors.toList());
    }

    public static UserDto mapToUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .build();
    }
}