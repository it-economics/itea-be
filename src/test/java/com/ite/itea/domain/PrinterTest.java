package com.ite.itea.domain;

import com.ite.itea.domain.dto.UserDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

class PrinterTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void shouldPrintUsersAsAString() {
        Printer printer = new Printer();

        UserDto peterPan = new UserDto("Peter", "Pan", List.of());
        UserDto captainHook = new UserDto("Captain", "Hook", List.of());

        List<UserDto> users = List.of(peterPan, captainHook);

        printer.printUsers(users);

        // We remove the trailing whitespace from the stream contents, because the output stream
        // seems to be pushing platform-specific line endings to the stream when flushing.
        final var strippedOutContent = outContent.toString().stripTrailing();

        then(strippedOutContent).isEqualTo("Peter Pan\nCaptain Hook");
    }

}
