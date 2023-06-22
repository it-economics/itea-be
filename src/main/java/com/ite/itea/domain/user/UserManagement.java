package com.ite.itea.domain.user;

import com.ite.itea.domain.dto.UserDto;
import com.ite.itea.persistence.UserRepository;

import java.util.List;

public class UserManagement {

    private final UserRepository userRepository;

    public UserManagement(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public UserDto getUserByLastname(String lastname) {
        return userRepository.getUserByLastname(lastname);
    }

    public void printAllUsers() {
        var users = getAllUsers();

        StringBuilder formattedUsers = new StringBuilder();

        for (var user : users) {
            formattedUsers
                    .append(user.formatUserToString())
                    .append("\n");
        }

        System.out.println(formattedUsers);
    }

}
