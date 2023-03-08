package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionHistory {
    private List<Transaction> transactions;

    public TransactionHistory() {
        transactions = new ArrayList<>();
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }



    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }
    public List<Transaction> getTransactionsByDate(Date date){
        List<Transaction> transactionsByDate = new ArrayList<>();

        for (Transaction t:transactions) {
            if (t.getDate().equals(date)){
                transactionsByDate.add(t);
            }
        }

        return transactionsByDate;
    }

    @Override
    public String toString() {
        return "\n" +
                "transactions=" + transactions;
    }
}
