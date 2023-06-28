package com.ite.itea.domain;

import com.ite.itea.application.dto.UserDto;

import java.util.List;
import java.util.stream.Collectors;

public class Printer {

    public void printUsers(List<UserDto> users) {
        String formattedUsers = users.stream()
                .map(UserDto::formatUserToString)
                .collect(Collectors.joining("\n"));

        System.out.println(formattedUsers);
    }
}
