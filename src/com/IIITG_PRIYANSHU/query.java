package com.IIITG_PRIYANSHU;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.*;

public class query extends JFrame implements ActionListener {
    String[] columnNames = {"ID", "Name", "Standing", "Major","Age"};
String query;

    Container container = getContentPane();
    JLabel admin = new JLabel("WELCOME TO DATABASE!!");
    JLabel label = new JLabel("Enter Query");

    JTextArea userTextField = new JTextArea();
    JButton run = new JButton("RUN");


    query() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        admin.setBounds(130, 20, 700, 50);
        admin.setFont(new Font("Aparajita", Font.BOLD, 30));
        admin.setForeground(Color.WHITE);
        label.setBounds(80, 120, 150, 30);
        label.setFont(new Font("Segoe UI",Font.BOLD,26));

        label.setForeground(Color.WHITE);

        userTextField.setBounds(80, 180, 450, 100);
       userTextField.setLineWrap(true);
       userTextField.setWrapStyleWord(true);
         userTextField.setFont(new Font("Segoe UI",Font.PLAIN,17));
        run.setBounds(80, 360, 100, 30);


    }

    public void addComponentsToContainer() {

        container.add(userTextField);
        container.add(label);
container.add(run);
        container.add(admin);
    }

    public void addActionEvent() {
        run.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource() == run) {
            query=userTextField.getText();
            try {
                showTable();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }


        }
        //Coding Part of RESET button
    }
    public void showTable() throws SQLException {
     JFrame   frame2=new JFrame("Database search Result");
        frame2.setBounds(200,200,1000,400);
     //   frame2.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame2.setResizable(true);


        DefaultTableModel model = new DefaultTableModel();

        //DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames());
        // table = new JTable(model);
      JTable  table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
       // table.setBackground(Color.darkGray);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        try{
            String pass="";
            File file = new File("C:\\Users\\hp\\Documents\\text.txt");
            if (file.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String a;
                while ((a = br.readLine()) != null) {
                    pass += a;
                }


            }


            String url = "jdbc:mysql://localhost:3306/real_estate";
            Connection conn = DriverManager.getConnection(url, "root", pass);
            PreparedStatement st=conn.prepareStatement(query);
            ResultSet rs=st.executeQuery();
            ResultSetMetaData metaData = (ResultSetMetaData) rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(metaData.getColumnName(i));
            }
            int i=0;
            while(rs.next())
            {

                    Object[] row = new Object[columnCount];
                    for (int k = 1; k <= columnCount; k++) {
                        row[k - 1] = rs.getObject(k);
                    }
                    model.addRow(row);
                    i++;

                }
            if(i==0) {
                JOptionPane.showMessageDialog(null, "No records found");

            }
            else {
                frame2.setVisible(true);
            }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error!! Kindly recheck the error");
        }




        frame2.add(scroll);
        //  frame2.setVisible(true);




    }
}




