package com.ite.itea.domain.user;

import com.ite.itea.domain.Printer;
import com.ite.itea.persistence.ConverterEntityToDto;
import com.ite.itea.persistence.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import static org.assertj.core.api.BDDAssertions.then;


class UserDtoManagementTest {

    private File file;

    private Printer printer;

    private UserRepository userRepository;

    private UserManagement userManagement;
    private ConverterEntityToDto converterEntityToDto;

    @BeforeEach
    public void setUp() {
        URL usersFileURL = getClass().getClassLoader().getResource("usersWithOrders/users.txt");
        String usersFilePath = Objects.requireNonNull(usersFileURL).getFile();
        file = new File(URLDecoder.decode(usersFilePath, StandardCharsets.UTF_8));
        converterEntityToDto = new ConverterEntityToDto();
        userRepository = new UserRepository(file, converterEntityToDto);
        userManagement = new UserManagement(printer, userRepository);
    }

    @Test
    void shouldReturnAllUsersWhenAllUsersAreRequested() {
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
    void shouldReturnCaptainHookWhenAUserWithTheNameHookIsSearched() {
        var user = userManagement.getUserByLastname("Hook");

        then(user.firstname()).isEqualTo("Captain");
        then(user.lastname()).isEqualTo("Hook");
    }
}
