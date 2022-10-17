package com.denmats.nplusone.service;

import com.denmats.nplusone.model.Address;
import com.denmats.nplusone.model.User;
import com.denmats.nplusone.repository.AddressRepository;
import com.denmats.nplusone.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    public static final int PAGE_SIZE = 4;
    private final UserRepository userRepository;

    private final AddressRepository addressRepository;

    public List<User> getUsers(int page, Sort.Direction sort){
        return userRepository.findAllUsers(PageRequest.of(page, PAGE_SIZE, Sort.by(sort, "id")));
    }

    public User getSingleUser(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public List<User> getUserByUsername(String username) {
        return userRepository.findAllByUsername(username);
    }

    public List<User> getUsersWithAddresses(int page, Sort.Direction sort) {
        List<User> allUsers = userRepository.findAllUsers(
                PageRequest.of(page, PAGE_SIZE,
                        Sort.by(sort, "id")));

        List<Long> userIds = allUsers.stream()
                .map(User::getId)
                .collect(Collectors.toList());

        List<Address> addresses = addressRepository.findAllByUserIdIsIn(userIds);
        allUsers.forEach(user -> user.setAddress(extractAddress(addresses, user.getId())));
        return allUsers;
    }

    private List<Address> extractAddress(List<Address> addresses, long id) {
        return addresses.stream()
                .filter(address -> address.getUserId() == id)
                .collect(Collectors.toList());
    }
}
