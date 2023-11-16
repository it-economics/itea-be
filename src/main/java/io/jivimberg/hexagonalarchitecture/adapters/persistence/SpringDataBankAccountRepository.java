package io.jivimberg.hexagonalarchitecture.adapters.persistence;

import io.jivimberg.hexagonalarchitecture.application.domain.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataBankAccountRepository extends JpaRepository<BankAccount, Long> { }
