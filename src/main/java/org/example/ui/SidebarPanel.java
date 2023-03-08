package org.example.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SidebarPanel extends JPanel {

    private JButton createAccountButton;
    private JButton depositButton;
    private JButton withdrawButton;
    private JButton transferButton;
    private JButton viewBalanceButton;
    private JButton transactionHistoryButton;

    public SidebarPanel() {
        setLayout(new GridLayout(6, 1, 5, 5));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Create buttons
        createAccountButton = new JButton("Create Account");
        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");
        transferButton = new JButton("Transfer");
        viewBalanceButton = new JButton("View Balance");
        transactionHistoryButton = new JButton("Transaction History");

        // Add buttons to panel
        add(createAccountButton);
        add(depositButton);
        add(withdrawButton);
        add(transferButton);
        add(viewBalanceButton);
        add(transactionHistoryButton);
    }

    public void setCreateAccountListener(ActionListener listener) {
        createAccountButton.addActionListener(listener);
    }

    public void setDepositListener(ActionListener listener) {
        depositButton.addActionListener(listener);
    }

    public void setWithdrawListener(ActionListener listener) {
        withdrawButton.addActionListener(listener);
    }

    public void setTransferListener(ActionListener listener) {
        transferButton.addActionListener(listener);
    }

    public void setViewBalanceListener(ActionListener listener) {
        viewBalanceButton.addActionListener(listener);
    }

    public void setTransactionHistoryListener(ActionListener listener) {
        transactionHistoryButton.addActionListener(listener);
    }
}
