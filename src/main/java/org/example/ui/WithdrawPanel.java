package org.example.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WithdrawPanel extends JPanel {
    private JLabel accountNumberLabel, withdrawalAmountLabel;
    private JTextField accountNumberField, withdrawalAmountField;
    private JButton submitButton;
    private JTextArea outputTextArea;

    public WithdrawPanel() {
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
