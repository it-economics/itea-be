package com.ite.itea.persistence;

import com.ite.itea.domain.dto.UserDto;
import com.ite.itea.persistence.entities.UserEntity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserRepository {

    private final File file;

    public UserRepository(File file) {
        this.file = file;
    }

    public List<UserDto> getAllUsers() {
        List<UserEntity> users = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(this.file))) {
            String line = br.readLine();

            while (line != null) {
                String[] userFromFile = line.split(" ");
                String[] ordersFromFile = userFromFile[2].split(",");

                var user = new UserEntity(userFromFile[0], userFromFile[1], Arrays.stream(ordersFromFile).toList());

                users.add(user);

                line = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return users.stream()
                .map(this::convertUserEntityToUserDto)
                .toList();
    }

    public UserDto getUserByLastname(String lastname) {
        List<UserDto> users = getAllUsers();

        var userResult = users.stream()
                .filter(user -> user.lastname().equals(lastname))
                .findFirst();

        return userResult.orElseGet(() -> new UserDto(null, null, null));
    }

    private UserDto convertUserEntityToUserDto(UserEntity userEntity) {
        return new UserDto(userEntity.firstname(), userEntity.lastname(), userEntity.purchasedItems());
    }

}
