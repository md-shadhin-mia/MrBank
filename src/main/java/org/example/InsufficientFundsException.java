package org.example;

public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(){
        super("Insufficient Founds in your account!");
    }
}
