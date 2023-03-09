package org.example.ui;

import org.example.AccountManager;
import org.example.CurrentAccount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DepositPanel extends JPanel {
    private final AccountManager accountManager;
    private JLabel accountNumberLabel;
    private JLabel amountLabel;
    private JTextField accountNumberField;
    private JTextField amountField;
    private JButton depositButton;
    private JTextArea outputTextArea;

    public DepositPanel() {
        accountManager = AccountManager.getInstance();
        // Set panel layout
        setLayout(new BorderLayout());

        // Create input panel
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        accountNumberLabel = new JLabel("Account Number:");
        accountNumberField = new JTextField();
        amountLabel = new JLabel("Amount:");
        amountField = new JTextField();
        inputPanel.add(accountNumberLabel);
        inputPanel.add(accountNumberField);
        inputPanel.add(amountLabel);
        inputPanel.add(amountField);

        // Create button panel
        JPanel buttonPanel = new JPanel();
        depositButton = new JButton("Deposit");
        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deposit();
            }
        });
        buttonPanel.add(depositButton);

        // Create output panel
        JPanel outputPanel = new JPanel(new BorderLayout());
        outputTextArea = new JTextArea(10, 30);
        outputTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        outputPanel.add(scrollPane, BorderLayout.CENTER);
        setBorder(BorderFactory.createTitledBorder("Deposit"));
        // Add panels to main panel
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(outputPanel, BorderLayout.SOUTH);
    }

    private void deposit() {
        // Get input values
        String accountNumber = accountNumberField.getText();
        double amount = Double.parseDouble(amountField.getText());

        // TODO: Process deposit transaction
        // This is where you would add the code to actually process the deposit transaction
        CurrentAccount account = accountManager.findAccount(accountNumber);
        account.deposit(amount);
        // Display output to user
        String output = "Deposited " + amount + " into account " + accountNumber;
        outputTextArea.setText(output);
    }
}
