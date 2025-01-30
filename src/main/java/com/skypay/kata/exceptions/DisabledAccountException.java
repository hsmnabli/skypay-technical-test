package com.skypay.kata.exceptions;

public class DisabledAccountException extends IllegalStateException {
    public DisabledAccountException(){
        super("This account is disabled");
    }
}
