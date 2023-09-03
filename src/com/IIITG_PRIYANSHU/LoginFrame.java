package com.IIITG_PRIYANSHU;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;

public class LoginFrame extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel admin=new JLabel("WELCOME TO ADMINISTRATOR PAGE!!");
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JCheckBox showPassword = new JCheckBox("Show Password");


    LoginFrame() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        admin.setBounds(100, 20, 700, 50);
        admin.setFont(new Font("Aparajita", Font.PLAIN, 25));
admin.setForeground(Color.WHITE);
        userLabel.setBounds(100, 150, 150, 50);
        userLabel.setForeground(Color.WHITE);

        passwordLabel.setBounds(100, 220, 100, 30);
        passwordLabel.setForeground(Color.WHITE);

        userTextField.setBounds(200, 150, 150, 30);
     //   userTextField.setForeground(Color.WHITE);
        passwordField.setBounds(200, 220, 150, 30);
    //    passwordField.setForeground(Color.WHITE);
        showPassword.setBounds(200, 280, 150, 30);

        loginButton.setBounds(120, 350, 100, 30);
      //  loginButton.setForeground(Color.WHITE);
        resetButton.setBounds(270, 350, 100, 30);
      //  resetButton.setForeground(Color.WHITE);


    }

    public void addComponentsToContainer() {
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
        container.add(admin);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = String.valueOf(passwordField.getPassword());
            if (userText.equalsIgnoreCase("root") && pwdText.equalsIgnoreCase("priyanshu")) {
                JOptionPane.showMessageDialog(this, "Login Successful");
                //JOptionPane.showMessageDialog(this,"Now you can access the database....");
                query frame = new query();
                frame.setTitle("Login Form");
                frame.setVisible(true);
                frame.setBounds(200, 100, 700, 550);
                JLabel jkl=new JLabel(new ImageIcon("type.jpg"));
                jkl.setLocation(0,0);
                jkl.setSize(700,550);
                frame.add(jkl);

              //  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);

            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }

        }
        //Coding Part of RESET button
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
        //Coding Part of showPassword JCheckBox
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }


        }
    }

}
