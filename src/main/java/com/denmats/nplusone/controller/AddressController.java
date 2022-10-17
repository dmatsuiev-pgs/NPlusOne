package com.denmats.nplusone.controller;

import com.denmats.nplusone.controller.dto.AddressDto;
import com.denmats.nplusone.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/addresses")
    public List<AddressDto> getAllAddresses(){
        return AddressDtoMapper.mapToAddressDtos(addressService.getAllAddresses());
    }

}
