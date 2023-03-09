package org.example;

import java.util.ArrayList;
import java.util.List;

// Assuming CurrentAccount class has a field called accountNumber
public class AccountManager {

    // A private static instance of the class
    private static AccountManager instance;

    // A private list of CurrentAccount objects
    private List<CurrentAccount> accounts;

    // A private constructor to prevent other classes from creating new instances
    private AccountManager() {
        accounts = new ArrayList<>();
    }

    // A public static method to get the singleton instance of the class
    public static AccountManager getInstance() {
        if (instance == null) {
            instance = new AccountManager();
        }
        return instance;
    }

    // A public method to add a CurrentAccount object to the list
    public void addAccount(CurrentAccount account) {
        accounts.add(account);
    }

    // A public method to find a CurrentAccount object by account number
    public CurrentAccount findAccount(String accountNumber) {
        for (CurrentAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null; // No matching account found
    }
}