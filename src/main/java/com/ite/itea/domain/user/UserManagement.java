package com.ite.itea.domain.user;

import com.ite.itea.domain.Printer;
import com.ite.itea.domain.dto.UserDto;
import com.ite.itea.persistence.UserRepository;

import java.util.List;

public class UserManagement {

    private final Printer printer;
    private final UserRepository userRepository;

    public UserManagement(Printer printer, UserRepository userRepository) {
        this.printer = printer;
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

        printer.printUsers(users);
    }

}
