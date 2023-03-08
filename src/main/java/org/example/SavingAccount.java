package org.example;

import java.util.Date;
import java.util.List;

public class SavingAccount extends CurrentAccount{
    private static final int LIMIT = 3;
    private final double INTEREST_RATE = 0.01;  // 1% interest rate
    public SavingAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }


    public void addInterest(){
        double interest = INTEREST_RATE * getBalance();
        deposit(interest);
    }

    //
    // windthow method overite


    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        List<Transaction> transactions = getTransactionHistory().getTransactionsByDate(new Date());
        if (transactions.size() > LIMIT){
            throw new InsufficientFundsException();
        }
        super.withdraw(amount);
    }
}
