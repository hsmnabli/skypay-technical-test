package com.skypay.kata;

public interface AccountService {
    void deposit(int amount);
    void withdraw(int amount);
    void printStatement();
}
