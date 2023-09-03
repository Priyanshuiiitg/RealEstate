package com.IIITG_PRIYANSHU;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class delete_property extends JFrame {
    private JLabel heading;
    private JTextField txt1;
    private JButton submit;
    private JButton rent;
    private JTable table;
    private JFrame frame2;
    String id;
    String[] columnNames = {"ID", "Name", "Standing", "Major","Age"};

    private JLabel agent;
    private Container c;
    public delete_property() throws IOException {




        setTitle("Update Property DB");
        setBounds(300,90,800,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        c=getContentPane();
        c.setLayout(null);
        heading =new JLabel("Remove a property from market!!");
        heading.setFont(new Font("Segoe UI", Font.BOLD,30));
        heading.setForeground(Color.WHITE);
//c.setBackground(Color.DARK_GRAY);


        heading.setSize(600, 30);
        heading.setLocation(200, 30);
        c.add(heading);
        agent = new JLabel("Property ID to remove from market ");
        agent.setFont(new Font("Segoe UI", Font.BOLD,20));
        agent.setSize(400, 40);
        agent.setLocation(100, 140);
        agent.setForeground(Color.WHITE);
        c.add(agent);
        txt1 = new JTextField();
        txt1.setFont(new Font("Segoe UI", Font.BOLD,15));
        txt1.setSize(190, 30);
        txt1.setLocation(450, 140);
        c.add(txt1);
        submit=new JButton("REMOVE");
        submit.setFont(new Font("Segoe UI", Font.BOLD, 15));
        submit.setSize(190, 30);
        submit.setLocation(240, 240);
        submit.setForeground(Color.BLACK);

        c.add(submit);


//        JPanel panel = new JPanel();
//        ImageIcon image = new ImageIcon("hello.jpeg");
//        JLabel label = new JLabel(image);
//        c.add(label);

        JLabel pic=new JLabel(new ImageIcon("hell.jpg"));
        pic.setLocation(0,0);
        pic.setSize(800,500);
        c.add(pic);








        submit.addActionListener(this::actionPerformed);
     //   rent.addActionListener(this::actionPerformed);
        //rent.addActionListener(this::actionPerformed);



    }
    public void actionPerformed(ActionEvent first)
    {
        if(first.getSource()==submit)
        {
            id=txt1.getText();


            showTable();
        }
//        if(first.getSource()==rent)
//        {
//            id=Integer.parseInt(txt1.getText());
//            showTable();
//        }
    }

    public void showTable()
    {

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
            Statement st=conn.createStatement();
//            ResultSet rs=st.executeQuery("select aadhaar_number from owner where property_ID="+id+";");
//            int x=rs.getInt(1);

            st.executeUpdate("delete from property where property_ID="+id+";");
            JOptionPane.showMessageDialog(null,"Successful deletion from database");





        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Some error occurred !! Kindly check the property ID");

            e.printStackTrace();
        }




   //     frame2.add(scroll);
        //  frame2.setVisible(true);




    }

    public static void main(String[] args) throws IOException {
        (new delete_property()).setVisible(true);

    }
}
