package com.ite.itea.persistence;

import com.ite.itea.application.dto.UserDto;
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

    private final ConverterEntityToDto converterEntityToDto;

    public UserRepository(File file, ConverterEntityToDto converterEntityToDto) {
        this.file = file;
        this.converterEntityToDto = converterEntityToDto;
    }

    public List<UserDto> getAllUsers() {
        List<UserEntity> userEntities = getAllUserEntities();

        return userEntities.stream()
                .map(converterEntityToDto::convertUserEntityToUserDto)
                .toList();
    }

    public UserDto getUserByLastname(String lastname) {
        UserEntity userEntity = getUserEntityByLastname(lastname);

        return converterEntityToDto.convertUserEntityToUserDto(userEntity);
    }


    private UserEntity getUserEntityByLastname(String lastname) {
        List<UserEntity> users = getAllUserEntities();

        var userResult = users.stream()
                .filter(user -> user.lastname().equals(lastname))
                .findFirst();

        return userResult.orElseGet(() -> new UserEntity(null, null, null));
    }

    private List<UserEntity> getAllUserEntities() {
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

        return users;
    }

}
