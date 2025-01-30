package com.skypay.kata;

import java.time.LocalDate;

public class Transaction {
    private int amount;
    private int balance;
    private LocalDate date;// the use of LocalDateTime to be more precise but i will follow the exercise format(dd/mm/yyyy)
    //private Transaction type;  To be more precise, we can add the type of transaction (Enum of WITHDRAW, DEPOSIT, TRANSFER...etc) to specify whether it is a debit or credit.

    public Transaction(int amount,int balance) {
        this.amount = amount;
        this.balance = balance;
        this.date = LocalDate.now();
    }

    public void print(){
        System.out.printf("%s\t||\t%d\t||\t%d%n",date,amount,balance);
    }


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
