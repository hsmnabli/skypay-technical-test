package com.skypay.kata.exceptions;

public class InvalidWithdrawAmountException extends IllegalStateException{
    public InvalidWithdrawAmountException(){
        super("Invalid Withdrawed Amount");
    }
    public InvalidWithdrawAmountException(String message){
        super(message);
    }
}
