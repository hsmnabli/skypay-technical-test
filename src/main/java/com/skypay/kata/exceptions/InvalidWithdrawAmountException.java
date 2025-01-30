package com.skypay.kata.exceptions;

public class InvalidWithdrawAmountException extends IllegalArgumentException{
    public InvalidWithdrawAmountException(){
        super("Invalid Withdraw Amount");
    }
    public InvalidWithdrawAmountException(String message){
        super(message);
    }
}
