package com.ite.itea.ecommerce.adapters.out.persistence;

import com.ite.itea.ecommerce.domain.user.User;
import com.ite.itea.ecommerce.domain.user.UserId;
import com.ite.itea.ecommerce.usecase.port.UserRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CsvFileUserRepository implements UserRepository {

    private final File usersFile;

    public CsvFileUserRepository(File usersFile) {
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
            final List<String> lines = Files.readAllLines(usersFile.toPath());
            List<User> result = new ArrayList<>();
            for (int i = 0; i < lines.size() - 1; i++) {
                result.add(this.parseUserFromCsv(lines.get(i)));
            }
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private User parseUserFromCsv(String line) {
        String[] cells = line.split(",");
        return new User(new UserId(cells[0]), cells[1], cells[2]);
    }
}
