package org.example.ui;

import javax.swing.*;
import java.awt.*;

public class BankFrame extends JFrame {

    private JPanel mainContentPanel;
    private SidebarPanel sidebarPanel;
    private CreateAccountPanel createAccountPanel;
    private DepositPanel depositPanel;
    private WithdrawPanel withdrawPanel;
    private TransferPanel transferPanel;
    private ViewBalancePanel viewBalancePanel;
    private TransactionHistoryPanel transactionHistoryPanel;

    public BankFrame() {
        setTitle("Bank Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));

        // Create main content panel
        mainContentPanel = new JPanel(new BorderLayout());

        // Create sidebar panel
        sidebarPanel = new SidebarPanel();
        mainContentPanel.add(sidebarPanel, BorderLayout.WEST);

        // Create account panels
        createAccountPanel = new CreateAccountPanel();
        depositPanel = new DepositPanel();
        withdrawPanel = new WithdrawPanel();
        transferPanel = new TransferPanel();
        viewBalancePanel = new ViewBalancePanel();
        transactionHistoryPanel = new TransactionHistoryPanel();

        // Add account panels to main content panel
        mainContentPanel.add(createAccountPanel, BorderLayout.CENTER);

        // Set up sidebar listener for create account panel
        sidebarPanel.setCreateAccountListener(e -> {
            mainContentPanel.remove(depositPanel);
            mainContentPanel.remove(withdrawPanel);
            mainContentPanel.remove(transferPanel);
            mainContentPanel.remove(viewBalancePanel);
            mainContentPanel.remove(transactionHistoryPanel);
            mainContentPanel.add(createAccountPanel, BorderLayout.CENTER);
            mainContentPanel.revalidate();
            mainContentPanel.repaint();
        });

        // Set up sidebar listener for deposit panel
        sidebarPanel.setDepositListener(e -> {
            mainContentPanel.remove(createAccountPanel);
            mainContentPanel.remove(withdrawPanel);
            mainContentPanel.remove(transferPanel);
            mainContentPanel.remove(viewBalancePanel);
            mainContentPanel.remove(transactionHistoryPanel);
            mainContentPanel.add(depositPanel, BorderLayout.CENTER);
            mainContentPanel.revalidate();
            mainContentPanel.repaint();
        });

        // Set up sidebar listener for withdraw panel
        sidebarPanel.setWithdrawListener(e -> {
            mainContentPanel.remove(createAccountPanel);
            mainContentPanel.remove(depositPanel);
            mainContentPanel.remove(transferPanel);
            mainContentPanel.remove(viewBalancePanel);
            mainContentPanel.remove(transactionHistoryPanel);
            mainContentPanel.add(withdrawPanel, BorderLayout.CENTER);
            mainContentPanel.revalidate();
            mainContentPanel.repaint();
        });

        // Set up sidebar listener for transfer panel
        sidebarPanel.setTransferListener(e -> {
            mainContentPanel.remove(createAccountPanel);
            mainContentPanel.remove(depositPanel);
            mainContentPanel.remove(withdrawPanel);
            mainContentPanel.remove(viewBalancePanel);
            mainContentPanel.remove(transactionHistoryPanel);
            mainContentPanel.add(transferPanel, BorderLayout.CENTER);
            mainContentPanel.revalidate();
            mainContentPanel.repaint();
        });

        // Set up sidebar listener for view balance panel
        sidebarPanel.setViewBalanceListener(e -> {
            mainContentPanel.remove(createAccountPanel);
            mainContentPanel.remove(depositPanel);
            mainContentPanel.remove(withdrawPanel);
            mainContentPanel.remove(transferPanel);
            mainContentPanel.remove(transactionHistoryPanel);
            mainContentPanel.add(viewBalancePanel, BorderLayout.CENTER);
            mainContentPanel.revalidate();
            mainContentPanel.repaint();
        });

        // Set up sidebar listener for transaction history panel
        sidebarPanel.setTransactionHistoryListener(e -> {
            mainContentPanel.remove(createAccountPanel);
            mainContentPanel.remove(depositPanel);
            mainContentPanel.remove(withdrawPanel);
            mainContentPanel.remove(transferPanel);
            mainContentPanel.remove(viewBalancePanel);
            mainContentPanel.add(transactionHistoryPanel, BorderLayout.CENTER);
            mainContentPanel.revalidate();
            mainContentPanel.repaint();
        });

        // Add main content panel to frame
        add(mainContentPanel);

        // Display the frame
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BankFrame();
            }
        });
    }
}
