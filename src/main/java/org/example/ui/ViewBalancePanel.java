package org.example.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewBalancePanel extends JPanel {
    private JLabel accountNumberLabel, balanceLabel;
    private JTextField accountNumberField;
    private JButton submitButton;
    private JTextArea outputTextArea;

    public ViewBalancePanel() {
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        setBorder(BorderFactory.createTitledBorder("View Balance"));

        accountNumberLabel = new JLabel("Account Number:");
        inputPanel.add(accountNumberLabel);
        accountNumberField = new JTextField();
        inputPanel.add(accountNumberField);

        balanceLabel = new JLabel("Balance: N/A");
        inputPanel.add(balanceLabel);

        // Create button panel
        JPanel buttonPanel = new JPanel();
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Add logic to get account balance and display it
                // For now, just print the submitted information
                System.out.println("View Balance requested:");
                System.out.println("Account Number: " + accountNumberField.getText());
            }
        });
        buttonPanel.add(submitButton);

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
}
