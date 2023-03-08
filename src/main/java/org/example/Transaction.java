package org.example;

import java.time.LocalDate;
import java.util.Date;

public class Transaction {
    private double amount;
    private LocalDate date;
    private String type;

    public Transaction(double amount, LocalDate date, String type) {
        this.amount = amount;
        this.date = date;
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "\n\tTransaction{" +
                "amount=" + amount +
                ", date=" + date +
                ", type='" + type + '\'' +
                '}';
    }
}
