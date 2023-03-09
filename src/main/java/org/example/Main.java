package org.example;

public class Main {
    public static void main(String[] args) throws InsufficientFundsException {
        CurrentAccount ca = new SavingAccount("1234", "Shadhin", 5000);

        ca.deposit(1000);
        ca.withdraw(1000);
        ca.withdraw(1000);
        ca.withdraw(1000);
        ca.withdraw(1000);
        ca.withdraw(1000);

        System.out.println(ca.getTransactionHistory());
    }
}