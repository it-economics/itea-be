package com.ite.itea.application.usecase;

import com.ite.itea.application.dto.UserDto;
import com.ite.itea.domain.user.UserRepository;

import java.util.List;
import java.util.Optional;

public class Users {

    private final UserRepository userRepository;

    public Users(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> findAll() {
        return userRepository.all();
    }

    public Optional<UserDto> findByLastName(String lastName) {
        return Optional.ofNullable(userRepository.byLastName(lastName));
    }
}
