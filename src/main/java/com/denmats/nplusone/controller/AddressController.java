package com.denmats.nplusone.controller;

import com.denmats.nplusone.controller.dto.AddressDto;
import com.denmats.nplusone.model.Address;
import com.denmats.nplusone.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/addresses")
    public Address addAddress(@RequestBody Address address){
        return addressService.addAddress(address);
    }

    @PutMapping("/addresses/{id}")
    public Address editAddress(@RequestBody Address address){
        return addressService.editAddress(address);
    }

    @DeleteMapping("addresses/{id}")
    public void deleteAddress(@PathVariable("id") long id){
        addressService.deleteAddress(id);
    }

}
