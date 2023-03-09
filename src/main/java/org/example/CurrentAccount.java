package org.example;

import java.time.LocalDate;

public class CurrentAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private TransactionHistory transactionHistory;
    public CurrentAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        transactionHistory = new TransactionHistory();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public TransactionHistory getTransactionHistory() {
        return transactionHistory;
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.addTransaction(new Transaction(amount, LocalDate.now(), "Deposit"));
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException();
        }
        balance -= amount;
        transactionHistory.addTransaction(new Transaction(-amount, LocalDate.now(), "Withdrawal"));
    }

    public void Transfer(double amount,CurrentAccount toAccount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException();
        }
        balance -= amount;
        toAccount.deposit(amount);
        transactionHistory.addTransaction(new TransferTransaction(LocalDate.now(), -amount,this, toAccount));
    }

    @Override
    public String toString() {
        return "CurrentAccount{\n" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountHolder='" + accountHolder + '\'' +
                ", balance=" + balance +
                ",\n ---------------transactionHistory------\n" + transactionHistory +"\n"+
                '}';
    }
}
