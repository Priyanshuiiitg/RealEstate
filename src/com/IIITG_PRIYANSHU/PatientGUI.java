package com.IIITG_PRIYANSHU;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PatientGUI extends JFrame implements ActionListener {
    private JTextField usernameTextField;
    private JPasswordField passwordField;
    private JTextField dateTextField;
    private JButton loginButton;
    private JPanel mainPanel;

    public PatientGUI() {
        // Set up the login page
        JPanel loginPanel = new JPanel(new GridLayout(4, 2));
        JLabel usernameLabel = new JLabel("Username:");
        usernameTextField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        JLabel dateLabel = new JLabel("Enter today's date (ddmmyyyy):");
        dateTextField = new JTextField();
        loginPanel.add(usernameLabel);
        loginPanel.add(usernameTextField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(dateLabel);
        loginPanel.add(dateTextField);
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        loginPanel.add(loginButton);

        // Set up the main panel
        mainPanel = new JPanel();
        JButton registrationButton = new JButton("Registration");
        registrationButton.addActionListener(this);
        JButton queriesButton = new JButton("Queries");
        queriesButton.addActionListener(this);
        JButton exportButton = new JButton("Export");
        exportButton.addActionListener(this);
        mainPanel.add(registrationButton);
        mainPanel.add(queriesButton);
        mainPanel.add(exportButton);

        // Add the login panel to the frame
        getContentPane().add(loginPanel);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Open in full screen
        setVisible(true);
    }

    // Rest of the code

    public static void main(String[] args) {
        new PatientGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
