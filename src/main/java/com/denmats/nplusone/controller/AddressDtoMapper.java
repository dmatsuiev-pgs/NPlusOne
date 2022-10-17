package com.denmats.nplusone.controller;

import com.denmats.nplusone.controller.dto.AddressDto;
import com.denmats.nplusone.model.Address;

import java.util.List;
import java.util.stream.Collectors;

public class AddressDtoMapper {

    private AddressDtoMapper() {}

    public static List<AddressDto> mapToAddressDtos(List<Address> addresses){
        return addresses.stream()
                .map(AddressDtoMapper::mapToAddressDto)
                .collect(Collectors.toList());

    }

    public static AddressDto mapToAddressDto(Address address) {
        return AddressDto.builder()
                .id(address.getId())
                .userId(address.getUserId())
                .zipCode(address.getZipCode())
                .city(address.getCity())
                .street(address.getStreet())
                .build();
    }
}
