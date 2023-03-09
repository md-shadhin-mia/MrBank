package org.example.ui;

import org.example.AccountManager;
import org.example.CurrentAccount;
import org.example.InsufficientFundsException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WithdrawPanel extends JPanel {
    private final AccountManager accountManager;
    private JLabel accountNumberLabel, withdrawalAmountLabel;
    private JTextField accountNumberField, withdrawalAmountField;
    private JButton submitButton;
    private JTextArea outputTextArea;

    public WithdrawPanel() {

        accountManager = AccountManager.getInstance();
        // Set panel layout
        setLayout(new BorderLayout());

        // Create input panel
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        accountNumberLabel = new JLabel("Account Number:");
        accountNumberField = new JTextField();
        withdrawalAmountLabel = new JLabel("Amount:");
        withdrawalAmountField = new JTextField();
        inputPanel.add(accountNumberLabel);
        inputPanel.add(accountNumberField);
        inputPanel.add(withdrawalAmountLabel);
        inputPanel.add(withdrawalAmountField);

        // Create button panel
        JPanel buttonPanel = new JPanel();
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Add logic to withdraw the specified amount from the account
                // For now, just print the submitted information
                System.out.println("Withdraw requested:");
                System.out.println("Account Number: " + accountNumberField.getText());
                System.out.println("Withdrawal Amount: " + withdrawalAmountField.getText());

                String accountNumber = accountNumberField.getText();
                double amount = Double.parseDouble(withdrawalAmountField.getText());

                CurrentAccount account = accountManager.findAccount(accountNumber);
                try {
                    account.withdraw(amount);
                    String output = "Withdraw " + amount + " from account " + accountNumber;
                    outputTextArea.setForeground(Color.GREEN);
                    outputTextArea.setText(output);
                } catch (Exception ex) {
                    outputTextArea.setForeground(Color.RED);
                    outputTextArea.setText(ex.getLocalizedMessage());
                }


            }
        });
        buttonPanel.add(submitButton);

        // Create output panel
        JPanel outputPanel = new JPanel(new BorderLayout());
        outputTextArea = new JTextArea(10, 30);
        outputTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        outputPanel.add(scrollPane, BorderLayout.CENTER);
        setBorder(BorderFactory.createTitledBorder("Withdraw"));
        // Add panels to main panel
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(outputPanel, BorderLayout.SOUTH);
    }
}
