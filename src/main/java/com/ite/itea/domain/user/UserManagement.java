package com.ite.itea.domain.user;

import com.ite.itea.domain.dto.UserDto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserManagement {

    private final File file;

    public UserManagement(File file) {
        this.file = file;
    }

    public List<UserDto> getAllUsers() {
        List<UserDto> users = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(this.file))) {
            String line = br.readLine();

            while (line != null) {
                String[] userFromFile = line.split(" ");
                String[] ordersFromFile = userFromFile[2].split(",");

                var user = new UserDto(userFromFile[0], userFromFile[1], Arrays.stream(ordersFromFile).toList());

                users.add(user);

                line = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return users;
    }

    public void printAllUsers() {
        var users = getAllUsers();

        StringBuilder formattedUsers = new StringBuilder();

        for (var user : users) {
            formattedUsers
                    .append(this.formatUserToString(user))
                    .append("\n"); // TODO: solution: method should be in User user.getAsString()
        }

        System.out.println(formattedUsers); // TODO: solution: split formatting and printing so you can test the formatting better
    }
    // TODO solution: put this method in a class that do everything with printing and formatting
    // TODO solution: pass users as a parameter

    public UserDto getUserByLastname(String lastname) {
        List<UserDto> users = getAllUsers();

        var userResult = users.stream()
                .filter(user -> user.lastname().equals(lastname))
                .findFirst();

        return userResult.orElseGet(() -> new UserDto(null, null, null));
    }
    // TODO: solution: extract the File calls to a different class
    // TODO: solution: Perhaps separate the call and the filtering
    // TODO: solution: create entity Object

    public String formatUserToString(UserDto userDto) {
        return userDto.firstname() + " " + userDto.lastname();
    }

    public List<String> getOrdersFromUser(UserDto userDto) {
        return userDto.purchasedItems();
    }


}
