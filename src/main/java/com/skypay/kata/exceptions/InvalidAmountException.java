package com.skypay.kata.exceptions;

public class InvalidAmountException extends IllegalArgumentException {

    public InvalidAmountException(){
        super("Invalid Amount");
    }
    public InvalidAmountException(String message){
        super(message);
    }

}
