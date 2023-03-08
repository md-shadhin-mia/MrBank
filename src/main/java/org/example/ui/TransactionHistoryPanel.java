package org.example.ui;
import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionHistoryPanel extends JPanel {
    private JLabel accountNumberLabel;
    private JComboBox<String> accountNumberComboBox;
    private JTextArea outputTextArea;

    public TransactionHistoryPanel() {
        // Set panel layout
        setLayout(new BorderLayout());

        // Create input panel
        JPanel inputPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        accountNumberLabel = new JLabel("Account Number:");
        accountNumberComboBox = new JComboBox<String>();
        accountNumberComboBox.addItem("24654");
        accountNumberComboBox.addItem("2465");
        accountNumberComboBox.addItem("246");
        accountNumberComboBox.addItem("24");
        inputPanel.add(accountNumberLabel);
        inputPanel.add(accountNumberComboBox);

        // Create output panel
        JPanel outputPanel = new JPanel(new BorderLayout());
        outputTextArea = new JTextArea(10, 30);
        outputTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        outputPanel.add(scrollPane, BorderLayout.CENTER);

        // Add panels to main panel
        add(inputPanel, BorderLayout.NORTH);
        add(outputPanel, BorderLayout.CENTER);
    }

   /* public void updateAccountList(ArrayList<BankAccount> accounts) {
        // Clear existing account list
        accountNumberComboBox.removeAllItems();

        // Add accounts to combo box
        for (BankAccount account : accounts) {
            accountNumberComboBox.addItem(account.getAccountNumber());
        }
    }

    public void updateTransactionHistory(BankAccount account) {
        // Clear existing transaction history
        outputTextArea.setText("");

        // Display transaction history for selected account
        if (account != null) {
            TransactionHistory transactionHistory = account.getTransactionHistory();
            List<Transaction> transactions = transactionHistory.getTransactions();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            for (Transaction transaction : transactions) {
                outputTextArea.append(dateFormat.format(transaction.getDate()) + " - " + transaction.getType() + ": " + transaction.getAmount() + "\n");
            }
        }
    }*/
}
