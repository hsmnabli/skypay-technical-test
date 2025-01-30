package com.skypay.kata;

import com.skypay.kata.exceptions.DisabledAccountException;
import com.skypay.kata.exceptions.InvalidAmountException;
import com.skypay.kata.exceptions.InvalidWithdrawAmountException;

import java.util.ArrayList;
import java.util.List;

public class Account implements AccountService{
    private int balance = 0;
    private List<Transaction> transactions = new ArrayList<>();
    private boolean active = true;

    //to check the account is it active or disabled
    private void accountActivity(){
        if(!active){
            throw new DisabledAccountException();
        }
    }

    public void newTransaction(int amount){
        Transaction transaction = new Transaction(amount,balance);
        transactions.add(0,transaction);
    }

    @Override
    public void deposit(int amount) {
        accountActivity();
        if(amount <= 0 ){
            throw new InvalidAmountException();
        }
        this.balance += amount;
        newTransaction(amount);
    }

    @Override
    public void withdraw(int amount) {
        accountActivity();
        if(amount > balance){
            throw new InvalidWithdrawAmountException("Oops!! The withdrawal amount is greater than your balance ");
        }
        else if (amount <= 0){
            throw new InvalidWithdrawAmountException("The withdrawal amount must be greater than zero");
        }
        balance -= amount;
        transactions.add(new Transaction(-amount,balance));
    }

    @Override
    public void printStatement() {
        accountActivity();
        System.out.printf("DATE\t||\tAMOUNT\t||\tBALANCE%n");
        for(Transaction transaction : transactions){
            transaction.print();
        }
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
