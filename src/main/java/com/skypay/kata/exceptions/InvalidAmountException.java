package com.skypay.kata.exceptions;

public class InvalidAmountException extends IllegalStateException {

    public InvalidAmountException(){
        super("Invalid Amount");
    }
    public InvalidAmountException(String message){
        super(message);
    }

}
