package com.denmats.nplusone.controller;

import com.denmats.nplusone.controller.dto.UserDto;
import com.denmats.nplusone.model.User;
import com.denmats.nplusone.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public List<UserDto> getUsers(@RequestParam(required = false) Integer page, Sort.Direction sort){
        int pageNumber = page != null && page > 0 ? page : 0;
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;
        return UserDtoMapper.mapToUserDtos(userService.getUsers(pageNumber, sortDirection));
    }

    @GetMapping("/users/addresses")
    public List<User> getUsersWithAddresses(@RequestParam(required = false) Integer page, Sort.Direction sort){
        int pageNumber = page != null && page > 0 ? page : 0;
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;
        return userService.getUsersWithAddresses(pageNumber, sortDirection);
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id){
        return userService.getSingleUser(id);
    }

    @GetMapping("/users/username")
    public List<User> getUserByUsername(String username){
    return userService.getUserByUsername(username);
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PutMapping("/users")
    public User editUser(@RequestBody User user){
     return userService.editUser(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable long id){
        userService.deleteUser(id);
    }

}
