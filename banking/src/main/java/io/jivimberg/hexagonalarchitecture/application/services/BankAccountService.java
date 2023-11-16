package io.jivimberg.hexagonalarchitecture.application.services;

import io.jivimberg.hexagonalarchitecture.application.domain.BankAccount;
import io.jivimberg.hexagonalarchitecture.application.port.incoming.DepositUseCase;
import io.jivimberg.hexagonalarchitecture.application.port.incoming.WithdrawUseCase;
import io.jivimberg.hexagonalarchitecture.application.port.outgoing.LoadAccountPort;
import io.jivimberg.hexagonalarchitecture.application.port.outgoing.SaveAccountPort;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

/*
    Service ties all the pieces (application ports) together and drive the execution

 */

public class BankAccountService implements DepositUseCase, WithdrawUseCase {

    private LoadAccountPort loadAccountPort;
    private SaveAccountPort saveAccountPort;

    public BankAccountService(LoadAccountPort loadAccountPort, SaveAccountPort saveAccountPort) {
        this.loadAccountPort = loadAccountPort;
        this.saveAccountPort = saveAccountPort;
    }

    // TODO -> CODE HERE

}
