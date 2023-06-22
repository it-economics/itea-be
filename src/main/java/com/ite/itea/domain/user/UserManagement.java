package com.ite.itea.domain.user;

import com.ite.itea.domain.dto.UserDto;
import com.ite.itea.persistence.UserRepository;

import java.io.File;
import java.util.List;

public class UserManagement {

    private final File file;

    private final UserRepository userRepository;

    public UserManagement(File file, UserRepository userRepository) {
        this.file = file;
        this.userRepository = userRepository;
    }

    public List<UserDto> getAllUsers() {
        return userRepository.getAllUsers();
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

    public UserDto getUserByLastname(String lastname) {
        List<UserDto> users = getAllUsers();

        var userResult = users.stream()
                .filter(user -> user.lastname().equals(lastname))
                .findFirst();

        return userResult.orElseGet(() -> new UserDto(null, null, null));
    }

}
