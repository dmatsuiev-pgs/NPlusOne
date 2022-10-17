package com.denmats.nplusone.service;

import com.denmats.nplusone.model.Address;
import com.denmats.nplusone.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressService {

    public static final int PAGE_SIZE = 5;
    private final AddressRepository addressRepository;

    public List<Address> getAllAddresses(Integer page, Sort.Direction sort){
        return addressRepository.findAllAddresses(PageRequest.of(page, PAGE_SIZE, Sort.by(sort, "id")));
    }

    public Address getSingleAddress(long id){
        Optional<Address> optionalAddress = addressRepository.findById(id);
        return optionalAddress.orElse(null);
    }



}
