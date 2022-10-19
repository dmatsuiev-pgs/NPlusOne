package com.denmats.nplusone.service;

import com.denmats.nplusone.model.Address;
import com.denmats.nplusone.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressService {

    public static final int PAGE_SIZE = 5;
    private final AddressRepository addressRepository;

    public List<Address> getAllAddresses(Integer page, Sort.Direction sort) {
        return addressRepository.findAllAddresses(PageRequest.of(page, PAGE_SIZE, Sort.by(sort, "id")));
    }

    public Address getSingleAddress(long id) {
        Optional<Address> optionalAddress = addressRepository.findById(id);
        return optionalAddress.orElse(null);
    }


    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }

    @Transactional
    public Address editAddress(Address address) {
        Address addressEdited = addressRepository.findById(address.getId()).orElseThrow();
        addressEdited.setCity(address.getCity());
        addressEdited.setStreet(address.getStreet());
        addressEdited.setZipCode(address.getZipCode());
        return addressEdited;
    }

    public void deleteAddress(long id) {
        addressRepository.findById(id).ifPresent(addressRepository::delete);
    }
}
