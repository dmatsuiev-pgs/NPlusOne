package com.denmats.nplusone.controller;

import com.denmats.nplusone.controller.dto.UserDto;
import com.denmats.nplusone.model.User;
import com.denmats.nplusone.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public List<UserDto> getUsers(@RequestParam(required = false) int page){
        int pageNumber = page >= 0 ? page : 0;
        return UserDtoMapper.mapToUserDtos(userService.getUsers(pageNumber));
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id){
        return userService.getSingleUser(id);
    }

    @GetMapping("/users/username")
    public List<User> getUserByUsername(String username){
        return userService.getUserByUsername(username);
    }
}
