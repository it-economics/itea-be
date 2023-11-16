package io.jivimberg.hexagonalarchitecture.adapters.persistence;

import io.jivimberg.hexagonalarchitecture.application.domain.BankAccount;
import io.jivimberg.hexagonalarchitecture.application.port.outgoing.LoadAccountPort;
import io.jivimberg.hexagonalarchitecture.application.port.outgoing.SaveAccountPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

/*
    BankAccountRepository connects the outgoing ports with the SpringDataBankAccountRepository
 */

@Component
public class BankAccountRepository implements LoadAccountPort, SaveAccountPort {

    private SpringDataBankAccountRepository repository;

    public BankAccountRepository(SpringDataBankAccountRepository repository) {
        this.repository = repository;
    }

    // TODO -> CODE HERE
}
