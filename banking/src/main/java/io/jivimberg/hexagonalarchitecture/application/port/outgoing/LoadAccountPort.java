package io.jivimberg.hexagonalarchitecture.application.port.outgoing;

import io.jivimberg.hexagonalarchitecture.application.domain.BankAccount;

import java.util.Optional;

/*
    These two outgoing ports are for our application to interact with the database
 */

public interface LoadAccountPort {
    Optional<BankAccount> load(Long id);
}