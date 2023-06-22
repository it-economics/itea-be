package com.ite.itea.persistence;

import com.ite.itea.domain.user.UserManagement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.Objects;

import static org.assertj.core.api.BDDAssertions.then;

class UserRepositoryTest {

    private File file;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        file = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("usersWithOrders/users.txt")).getFile());
    }

    @Test
    void shouldReturnCaptainHookWhenAUserWithTheNameHookIsSearched() {
        var userManagement = new UserManagement(file);

        var user = userManagement.getUserByLastname("Hook");

        then(user.firstname()).isEqualTo("Captain");
        then(user.lastname()).isEqualTo("Hook");
    }

}