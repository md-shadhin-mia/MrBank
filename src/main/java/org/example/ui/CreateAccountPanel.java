package org.example.ui;

import org.example.AccountManager;
import org.example.CurrentAccount;
import org.example.FixedAccount;
import org.example.SavingAccount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;

public class CreateAccountPanel extends JPanel {
    private JLabel accountNumberLabel;
    private JLabel accountHolderNameLabel;
    private JLabel initialBalanceLabel;
    private JLabel accountTypeLabel;
    private JTextField accountNumberField;
    private JTextField accountHolderNameField;
    private JTextField initialBalanceField;
    private JComboBox<String> accountTypeComboBox;
    private JButton createAccountButton;
    private JTextArea outputTextArea;
    private AccountManager accountManager;
    public CreateAccountPanel() {
        accountManager = AccountManager.getInstance();
        // Set panel layout
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Create Account"));
        // Create input panel
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        accountNumberLabel = new JLabel("Account Number:");
        accountNumberField = new JTextField();
        accountHolderNameLabel = new JLabel("Account Holder Name:");
        accountHolderNameField = new JTextField();
        initialBalanceLabel = new JLabel("Initial Balance:");
        initialBalanceField = new JTextField();
        accountTypeLabel = new JLabel("Account Type:");
        accountTypeComboBox = new JComboBox<>(new String[]{"Current", "Savings", "Fixed(1-year)"});
        inputPanel.add(accountNumberLabel);
        inputPanel.add(accountNumberField);
        inputPanel.add(accountHolderNameLabel);
        inputPanel.add(accountHolderNameField);
        inputPanel.add(initialBalanceLabel);
        inputPanel.add(initialBalanceField);
        inputPanel.add(accountTypeLabel);
        inputPanel.add(accountTypeComboBox);

        // Create button panel
        JPanel buttonPanel = new JPanel();
        createAccountButton = new JButton("Create Account");
        createAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createAccount();
            }
        });
        buttonPanel.add(createAccountButton);

        // Create output panel
        JPanel outputPanel = new JPanel(new BorderLayout());
        outputTextArea = new JTextArea(10, 30);
        outputTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        outputPanel.add(scrollPane, BorderLayout.CENTER);

        // Add panels to main panel
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(outputPanel, BorderLayout.SOUTH);
    }

    private void createAccount() {
        // Get input values
        String accountNumber = accountNumberField.getText();
        String accountHolderName = accountHolderNameField.getText();
        double initialBalance = Double.parseDouble(initialBalanceField.getText());
        String accountType = (String) accountTypeComboBox.getSelectedItem();

        // Print input values to console
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Initial Balance: " + initialBalance);
        System.out.println("Account Type: " + accountType);
        //Creating account
        CurrentAccount account;
        if(accountType =="Current"){
            account = new CurrentAccount(accountNumber, accountHolderName, initialBalance);
        }else if(accountType == "Savings"){
            account = new SavingAccount(accountNumber, accountHolderName, initialBalance);
        }else{
            account = new FixedAccount(accountNumber, accountHolderName, initialBalance, 12, LocalDate.now());
        }

        accountManager.addAccount(account);
        outputTextArea.setText("Account Create Successfully!");
        /*
        * TODO: create logic for Account type
        * */

    }
}
