package com.ite.itea.application.usecase;

import com.ite.itea.domain.user.User;
import com.ite.itea.domain.user.UserRepository;

import java.util.List;
import java.util.Optional;

public class Users {

    private final UserRepository userRepository;

    public Users(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.all();
    }

    public Optional<User> findByLastName(String lastName) {
        return userRepository.byLastName(lastName);
    }
}
