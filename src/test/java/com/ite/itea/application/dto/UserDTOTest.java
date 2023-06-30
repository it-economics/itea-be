package com.ite.itea.application.dto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

class UserDTOTest {

    @Test
    void shouldReturnUserAsFormatFirstnameAndLastname() {
        UserDTO user = new UserDTO("Peter", "Pan", List.of("Pans"));

        then(user.formatUserToString()).isEqualTo("Peter Pan");
    }

}
