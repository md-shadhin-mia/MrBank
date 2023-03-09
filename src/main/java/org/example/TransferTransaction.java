package org.example;

import java.time.LocalDate;
import java.util.Date;

public class TransferTransaction extends Transaction {
    private CurrentAccount sourceAccount;
    private CurrentAccount destinationAccount;

    public TransferTransaction(LocalDate date, double amount, CurrentAccount sourceAccount, CurrentAccount destinationAccount) {
        super(amount, date, "Transfer");
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
    }

    public CurrentAccount getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(CurrentAccount sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public CurrentAccount getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(CurrentAccount destinationAccount) {
        this.destinationAccount = destinationAccount;
    }

    @Override
    public String toString() {
        return "TransferTransaction{" +
                    "\namount=" + this.getAmount() +
                    "\ndate=" + this.getDate() +
                    "\nsource Account Number=" + sourceAccount.getAccountNumber() +
                    "\ndestination Account Number=" + destinationAccount.getAccountNumber() +
                '}';
    }
}
