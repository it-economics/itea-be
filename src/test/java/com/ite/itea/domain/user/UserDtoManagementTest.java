package com.ite.itea.domain.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.Objects;

import static org.assertj.core.api.BDDAssertions.then;

class UserDtoManagementTest {

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

    @Test
    void shouldReturnAllUsersWhenAllUsersAreRequested() {
        var userManagement = new UserManagement(file);

        var users = userManagement.getAllUsers();

        then(users.size()).isEqualTo(4);
        then(users.get(0).firstname()).isEqualTo("Peter");
        then(users.get(0).lastname()).isEqualTo("Pan");
        then(users.get(1).firstname()).isEqualTo("Captain");
        then(users.get(1).lastname()).isEqualTo("Hook");
        then(users.get(2).firstname()).isEqualTo("Tinker");
        then(users.get(2).lastname()).isEqualTo("Bell");
        then(users.get(3).firstname()).isEqualTo("Lost");
        then(users.get(3).lastname()).isEqualTo("Boys");
    }

    @Test
    void shouldReturnUserAsFormatFirstnameAndLastname() {
        var userManagement = new UserManagement(file);
        var userFromManagement = userManagement.getUserByLastname("Pan");

        var user = userManagement.formatUserToString(userFromManagement);

        then(user).isEqualTo("Peter Pan");
    }

    @Test
    void shouldPrintAllUsersAsAString() {
        var userManagement = new UserManagement(file);

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