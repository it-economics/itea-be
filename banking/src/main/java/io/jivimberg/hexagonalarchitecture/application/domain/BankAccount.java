package io.jivimberg.hexagonalarchitecture.application.domain;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/*
    BankAccounts main responsibility is to model the business rules.
    It also verifies that the objects are always in a valid state
    The domain model should have no dependency on any specific technology.
    That is the reason why you will find no Spring annotations here.

    !!!!
    IN OUR CASE FOR SIMPLICITY REASONS BankAccount class is also used as Entity object
    !!!!


 */
@Entity
@Table(name = "bank_accounts")
public class BankAccount {

    @javax.persistence.Id
    @Id
    private Long id;
    private BigDecimal balance;

    public BankAccount(Long id, BigDecimal balance) {
        this.id = id;
        this.balance = balance;
    }

    public BankAccount() {

    }

    public boolean withdraw(BigDecimal amount) {
        if(balance.compareTo(amount) < 0) {
            return false;
        }

        balance = balance.subtract(amount);
        return true;
    }

    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
