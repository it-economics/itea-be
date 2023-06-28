package com.ite.itea.persistence.user;

import com.ite.itea.domain.user.User;
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

    public List<User> all() {
        return getAllUserEntities();
    }

    public Optional<User> byLastName(String lastName) {
        User user = getUserEntityByLastname(lastName);
        return Optional.of(user);
    }

    private User getUserEntityByLastname(String lastname) {
        List<User> users = getAllUserEntities();

        var userResult = users.stream()
                .filter(user -> user.lastname().equals(lastname))
                .findFirst();

        return userResult.orElseGet(() -> new User(null, null, null));
    }

    private List<User> getAllUserEntities() {
        List<User> users = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(this.file))) {
            String line = br.readLine();

            while (line != null) {
                String[] userFromFile = line.split(" ");
                String[] ordersFromFile = userFromFile[2].split(",");

                var user = new User(userFromFile[0], userFromFile[1], Arrays.stream(ordersFromFile).toList());

                users.add(user);

                line = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return users;
    }

}
