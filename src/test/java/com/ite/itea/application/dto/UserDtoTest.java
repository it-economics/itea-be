package com.ite.itea.application.dto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

class UserDtoTest {

    @Test
    void shouldReturnUserAsFormatFirstnameAndLastname() {
        UserDto user = new UserDto("Peter", "Pan", List.of("Pans"));

        then(user.formatUserToString()).isEqualTo("Peter Pan");
    }

}
