package com.denmats.nplusone.controller.dto;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserDto {
    private Long id;
    private String username;
}
