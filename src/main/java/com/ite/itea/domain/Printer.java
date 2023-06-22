package com.ite.itea.domain;

import com.ite.itea.domain.dto.UserDto;

import java.util.List;

public class Printer {

    public void printUsers(List<UserDto> users) {
        StringBuilder formattedUsers = new StringBuilder();

        for (var user : users) {
            formattedUsers
                    .append(user.formatUserToString())
                    .append("\n");
        }

        System.out.println(formattedUsers);
    }
}
