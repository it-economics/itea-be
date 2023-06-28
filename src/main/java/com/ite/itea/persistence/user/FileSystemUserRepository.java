package com.ite.itea.persistence.user;

import com.ite.itea.application.dto.UserDto;
import com.ite.itea.domain.user.UserRepository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FileSystemUserRepository implements UserRepository {

    private final File file;

    public FileSystemUserRepository(File file) {
        this.file = file;
    }

    public List<UserDto> all() {
        List<UserEntity> userEntities = getAllUserEntities();

        return userEntities.stream()
                .map(this::convertUserEntityToUserDto)
                .toList();
    }

    public Optional<UserDto> byLastName(String lastName) {
        UserEntity userEntity = getUserEntityByLastname(lastName);

        return Optional.of(convertUserEntityToUserDto(userEntity));
    }

    private UserDto convertUserEntityToUserDto(UserEntity userEntity) {
        return new UserDto(userEntity.firstname(), userEntity.lastname(), userEntity.purchasedItems());
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
