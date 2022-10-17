package com.denmats.nplusone.controller.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AddressDto {

    private Long id;

    private Long userId;

    private String street;

    private String zipCode;

    private String city;
}
