package com.ite.itea.application.usecase;

import com.ite.itea.application.dto.UserDto;
import com.ite.itea.domain.user.UserRepository;

import java.util.List;

public class Users {

    private final UserRepository userRepository;

    public Users(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> findAll() {
        return userRepository.all();
    }

    public UserDto findByLastName(String lastName) {
        return userRepository.byLastName(lastName);
    }
}
