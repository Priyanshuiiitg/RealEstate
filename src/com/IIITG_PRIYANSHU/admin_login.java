package com.IIITG_PRIYANSHU;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class admin_login {
    public static void main(String[] a) {
        LoginFrame frame = new LoginFrame();
        frame.setTitle("Login Form");
        frame.setVisible(true);
        frame.setBounds(200, 100, 700, 550);
        JLabel jkl=new JLabel(new ImageIcon("lok.jpg"));
        jkl.setLocation(0,0);
        jkl.setSize(700,550);
        frame.add(jkl);

    //    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

    }


}