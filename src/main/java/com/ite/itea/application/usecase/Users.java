package com.ite.itea.application.usecase;

import com.ite.itea.application.dto.UserDto;
import com.ite.itea.domain.user.UserRepository;

import java.util.List;

public class Users {

    private final UserRepository userRepository;

    public Users(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public UserDto getUserByLastname(String lastname) {
        return userRepository.getUserByLastname(lastname);
    }
}
