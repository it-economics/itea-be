package com.ite.itea.application.usecase;

import com.ite.itea.application.dto.UserDto;
import com.ite.itea.domain.Printer;
import com.ite.itea.domain.user.UserRepository;

import java.util.List;

public class Users {

    private final Printer printer;
    private final UserRepository userRepository;

    public Users(Printer printer, UserRepository userRepository) {
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
