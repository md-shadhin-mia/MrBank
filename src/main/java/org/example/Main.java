package org.example;

public class Main {
    public static void main(String[] args) throws InsufficientFundsException {
        CurrentAccount ca = new CurrentAccount("1234", "Shadhin", 5600);

        ca.deposit(400);
        ca.withdraw(3000);
        ca.deposit(1000);

        System.out.println(ca.getTransactionHistory());
    }
}