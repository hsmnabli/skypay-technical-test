package com.skypay.kata;

import com.skypay.kata.exceptions.InvalidAmountException;
import com.skypay.kata.exceptions.InvalidWithdrawAmountException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AccountTest {

    @Spy
    Account account = new Account();

    @Test
    public void should_deposit_amount() {
        int oldBalance = account.getBalance();
        int depositAmount = 1000;
        account.deposit(depositAmount);
        assertEquals(depositAmount + oldBalance, account.getBalance());
    }

    @Test
    public void should_throw_exception_when_deposit_less_than_or_equal_zero() {
        int oldBalance = account.getBalance();
        int depositAmount = -12;
        assertThrows(InvalidAmountException.class, () -> account.deposit(depositAmount));
        assertEquals(oldBalance, account.getBalance());
    }

    @Test
    public void should_withdraw_amount() {
        int oldBalance = 2500;
        account.setBalance(oldBalance); //Assuming that we have already a balance in our account
        int withdrawAmount = 500;
        account.withdraw(withdrawAmount);
        assertEquals(oldBalance - withdrawAmount, account.getBalance());
    }

    @Test
    public void should_throw_exception_when_withdraw_amount_greater_than_balance() {
        int oldBalance = 1000;
        account.setBalance(oldBalance);
        int withdrawAmount = 1200;
        assertThrows(InvalidWithdrawAmountException.class, () -> account.withdraw(withdrawAmount));
        assertEquals(oldBalance, account.getBalance());
    }

    @Test
    public void should_throw_exception_when_withdraw_amount_equal_zero() {
        int oldBalance = account.getBalance();
        int zero = 0;
        assertThrows(InvalidWithdrawAmountException.class, () -> account.withdraw(zero));
        assertEquals(oldBalance, account.getBalance());
    }

    @Test
    public void should_throw_exception_when_withdraw_amount_less_than_zero() {
        int oldBalance = account.getBalance();
        int negativeNumber = -1;
        assertThrows(InvalidWithdrawAmountException.class, () -> account.withdraw(negativeNumber));
        assertEquals(oldBalance, account.getBalance());
    }

    //We only verify if print in transaction is called
    //We don't need Transaction.print() method to be tested, it should be tested in a dedicated class
    @Test
    public void should_print_statement() {
        Transaction firstDeposit = Mockito.mock(Transaction.class);
        Transaction secondDeposit = Mockito.mock(Transaction.class);
        Transaction withdraw = Mockito.mock(Transaction.class);
        account.setTransactions(List.of(firstDeposit, secondDeposit, withdraw));
        account.printStatement();
        verify(firstDeposit, times(1)).print();
        verify(secondDeposit, times(1)).print();
        verify(withdraw, times(1)).print();
    }

    @Test
    public void should_create_transaction_on_deposit() {
        int depositAmount = 700;
        account.deposit(depositAmount);
        List<Transaction> transactions = account.getTransactions();
        assertFalse(transactions.isEmpty());
        assertEquals(depositAmount, transactions.get(0).getAmount());
    }

    @Test
    public void should_create_transaction_on_withdraw() {
        int oldBalance = 1000;
        account.setBalance(oldBalance);
        int withdrawalAmount = 700;
        account.withdraw(withdrawalAmount);
        List<Transaction> transactions = account.getTransactions();
        assertFalse(transactions.isEmpty());
        assertEquals(-withdrawalAmount, transactions.get(0).getAmount());
    }


}
