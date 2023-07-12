package com.ite.itea.persistence;

import com.ite.itea.domain.user.User;
import com.ite.itea.domain.user.UserId;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FileSystemUserRepositoryImpl implements FileSystemUserRepository {

    private final File usersFile;

    public FileSystemUserRepositoryImpl(File usersFile) {
        this.usersFile = usersFile;
    }

    public List<User> all() {
        return parseUsersFromFile(usersFile);
    }

    @Override
    public Optional<User> byId(UserId id) {
        return parseUsersFromFile(usersFile).stream()
                .filter(user -> user.id().equals(id))
                .findFirst();
    }

    public Optional<User> byLastName(String lastName) {
        return parseUsersFromFile(usersFile).stream()
                .filter(user -> user.lastname().equals(lastName))
                .findFirst();
    }

    private List<User> parseUsersFromFile(File usersFile) {
        try {
            final var lines = Files.readAllLines(usersFile.toPath());
            return lines.stream()
                    .map(this::parseUserFromCsv)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private User parseUserFromCsv(String line) {
        String[] cells = line.split(",");
        return new User(new UserId(cells[0]), cells[1], cells[2]);
    }
}
