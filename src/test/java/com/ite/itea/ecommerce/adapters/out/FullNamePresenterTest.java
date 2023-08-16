package com.ite.itea.ecommerce.adapters.out;

import static org.assertj.core.api.Assertions.assertThat;

import com.ite.itea.ecommerce.adapters.out.presenter.FullNamePresenter;
import com.ite.itea.ecommerce.domain.user.User;
import com.ite.itea.ecommerce.domain.user.UserId;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FullNamePresenterTest {

    @ParameterizedTest
    @CsvSource("""
            Peter, Parker, Full name: Peter Parker
            Hermione, Granger, Full name: Hermione Granger
            """)
    void shouldFormatCorrectly(String firstName, String lastName, String expectedFormatted) {
        final var user = new User(UserId.random(), firstName, lastName);

        final var fullNamePresenter = new FullNamePresenter();
        final var actual = fullNamePresenter.formatFullName(user);

        assertThat(actual).isEqualTo(expectedFormatted);
    }
}
