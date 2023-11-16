package io.jivimberg.hexagonalarchitecture.application.port.incoming;

import java.math.BigDecimal;

/*
    With ports our business logic interact with the outside world.
    These ports are used by external components to call our application

 */
public interface DepositUseCase {
    void deposit(Long id, BigDecimal amount);
}