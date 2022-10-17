package com.denmats.nplusone.controller;

import com.denmats.nplusone.controller.dto.AddressDto;
import com.denmats.nplusone.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/addresses")
    public List<AddressDto> getAllAddresses(@RequestParam(required = false) Integer page, Sort.Direction sort){
        int pageNumber = page != null && page > 0 ? page : 0;
        Sort.Direction direction = sort != null ? sort : Sort.Direction.ASC;
        return AddressDtoMapper.mapToAddressDtos(addressService.getAllAddresses(pageNumber, direction));
    }

    @GetMapping("/addresses/{id}")
    public AddressDto getSingleAddress(@PathVariable("id") long id){
        return AddressDtoMapper.mapToAddressDto(addressService.getSingleAddress(id));
    }

}
