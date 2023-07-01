package com.ite.itea.domain;

import com.ite.itea.domain.user.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @Test
    void shouldReturnUserAsFormatFirstnameAndLastname() {
        User user = new User("Peter", "Pan", List.of("Pans"));

        assertThat(user.formatFullName()).isEqualTo("Peter Pan");
    }

}
