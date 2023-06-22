package com.ite.itea.domain.user;

import com.ite.itea.persistence.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.Objects;

import static org.assertj.core.api.BDDAssertions.then;

class UserDtoManagementTest {

    private File file;

    private UserRepository userRepository;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        file = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("usersWithOrders/users.txt")).getFile());
        userRepository = new UserRepository(file);
    }

    @Test
    void shouldPrintAllUsersAsAString() {
        var userManagement = new UserManagement(file, userRepository);

        userManagement.printAllUsers();

        then(outContent.toString()).isEqualTo(
                """
                        Peter Pan
                        Captain Hook
                        Tinker Bell
                        Lost Boys
                                                
                        """);
    }
}