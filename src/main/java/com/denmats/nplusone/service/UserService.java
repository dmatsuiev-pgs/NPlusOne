package com.denmats.nplusone.service;

import com.denmats.nplusone.model.User;
import com.denmats.nplusone.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    public static final int PAGE_SIZE = 2;
    private final UserRepository userRepository;

    public List<User> getUsers(int page){
        return userRepository.findAllUsers(PageRequest.of(page, PAGE_SIZE));
    }

    public User getSingleUser(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public List<User> getUserByUsername(String username) {
        return userRepository.findAllByUsername(username);
    }
}
