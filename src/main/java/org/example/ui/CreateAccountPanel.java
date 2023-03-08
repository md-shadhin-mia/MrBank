package org.example.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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

    public CreateAccountPanel() {
        // Set panel layout
        setLayout(new BorderLayout());

        // Create input panel
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        accountNumberLabel = new JLabel("Account Number:");
        accountNumberField = new JTextField();
        accountHolderNameLabel = new JLabel("Account Holder Name:");
        accountHolderNameField = new JTextField();
        initialBalanceLabel = new JLabel("Initial Balance:");
        initialBalanceField = new JTextField();
        accountTypeLabel = new JLabel("Account Type:");
        accountTypeComboBox = new JComboBox<>(new String[]{"Checking", "Savings"});
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


    }
}
