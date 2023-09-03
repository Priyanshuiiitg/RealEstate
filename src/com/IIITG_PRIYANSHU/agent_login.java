package com.IIITG_PRIYANSHU;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class agent_login {
    public static void main(String[] a) {
        agent_loginframe frame = new agent_loginframe();
        frame.setTitle("Login Form");
        frame.setVisible(true);
        frame.setBounds(200, 100, 700, 550);
        JLabel jkl=new JLabel(new ImageIcon("agent.jpg"));
        jkl.setLocation(0,0);
        jkl.setSize(700,550);
        frame.add(jkl);

        //    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

    }


}