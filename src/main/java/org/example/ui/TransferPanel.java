package org.example.ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransferPanel extends JPanel {
    private JLabel accountNumberLabel, amountLabel, toAccountNumberLabel;
    private JTextField accountNumberField, amountField, toAccountNumberField;
    private JButton submitButton;
    private JTextArea outputTextArea;

    public TransferPanel() {
        setLayout(new BorderLayout());

        // Create input panel
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        setBorder(BorderFactory.createTitledBorder("Transfer"));

        accountNumberLabel = new JLabel("Account Number:");
        inputPanel.add(accountNumberLabel);
        accountNumberField = new JTextField();
        inputPanel.add(accountNumberField);

        toAccountNumberLabel = new JLabel("To Account Number:");
        inputPanel.add(toAccountNumberLabel);
        toAccountNumberField = new JTextField();
        inputPanel.add(toAccountNumberField);

        amountLabel = new JLabel("Amount:");
        inputPanel.add(amountLabel);
        amountField = new JTextField();
        inputPanel.add(amountField);
        JPanel buttonPanel = new JPanel();
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Print submitted information
                System.out.println("Transfer requested:");
                System.out.println("From Account Number: " + accountNumberField.getText());
                System.out.println("To Account Number: " + toAccountNumberField.getText());
                System.out.println("Amount: " + amountField.getText());
            }
        });
        buttonPanel.add(submitButton);

        // Create output panel
        JPanel outputPanel = new JPanel(new BorderLayout());
        outputTextArea = new JTextArea(10, 30);
        outputTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        outputPanel.add(scrollPane, BorderLayout.CENTER);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(outputPanel, BorderLayout.SOUTH);
    }
}
