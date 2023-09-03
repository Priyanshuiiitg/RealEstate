package com.IIITG_PRIYANSHU;


import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class agent_buyer_update extends JFrame {
    private JLabel heading;
    private JTextField txt1;

    private JTextField first;

    private JTextField sec;
    private JTextField thr;
    private JTextField four;



    private JButton submit;
    private JButton rent;
    private JTable table;
    private JFrame frame2;
    String w,x;
    int y;
    String z="",a="";
    String[] columnNames = {"ID", "Name", "Standing", "Major","Age"};

    private JLabel agent;
    private Container c;
    public agent_buyer_update() throws IOException {




        setTitle("Transaction");
        setBounds(300,90,800,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        c=getContentPane();
        c.setLayout(null);
        heading =new JLabel("Agent Buyer Transaction update");
        heading.setFont(new Font("Segoe UI", Font.BOLD,30));
        heading.setForeground(Color.WHITE);
//c.setBackground(Color.DARK_GRAY);


        heading.setSize(600, 36);
        heading.setLocation(200, 30);
        c.add(heading);
        agent = new JLabel("Agent Aadhaar No ");
        agent.setFont(new Font("Segoe UI", Font.BOLD,20));
        agent.setSize(200, 40);
        agent.setLocation(100, 140);
        agent.setForeground(Color.WHITE);
        c.add(agent);
        JLabel by=new JLabel("Buyer's Aadhaar No ");
        by.setFont(new Font("Segoe UI", Font.BOLD,20));
        by.setSize(200, 40);
        by.setLocation(100, 200);
        by.setForeground(Color.WHITE);
        c.add(by);
        JLabel id=new JLabel("   Property ID ");
        id.setFont(new Font("Segoe UI", Font.BOLD,20));
        id.setSize(200, 40);
        id.setLocation(100, 260);
        id.setForeground(Color.WHITE);
        c.add(id);
        JLabel date=new JLabel("Year of transaction ");
        date.setFont(new Font("Segoe UI", Font.BOLD,20));
        date.setSize(200, 40);
        date.setLocation(100, 320);
        date.setForeground(Color.WHITE);
        c.add(date);






        txt1 = new JTextField();
        txt1.setFont(new Font("Segoe UI", Font.BOLD,15));
        txt1.setSize(190, 30);
        txt1.setLocation(320, 140);
        c.add(txt1);
        first=new JTextField();
        first.setFont(new Font("Segoe UI", Font.BOLD,15));
        first.setSize(190, 30);
        first.setLocation(320, 200);
        c.add(first);

        sec=new JTextField();
        sec.setFont(new Font("Segoe UI", Font.BOLD,15));
        sec.setSize(190, 30);
        sec.setLocation(320, 260);
        c.add(sec);

        thr=new JTextField();
        thr.setFont(new Font("Segoe UI", Font.BOLD,15));
        thr.setSize(190, 30);
        thr.setLocation(320, 320);
        c.add(thr);
        JLabel  dof=new JLabel("Date of Transaction ");
        dof.setFont(new Font("Segoe UI", Font.BOLD,20));
        dof.setSize(200, 40);
        dof.setLocation(100, 380);
        dof.setForeground(Color.WHITE);
        c.add(dof);

        four=new JTextField();
        four.setFont(new Font("Segoe UI", Font.BOLD,15));
        four.setSize(190, 30);
        four.setLocation(320, 380);
        c.add(four);








        submit=new JButton("Update");
        submit.setFont(new Font("Segoe UI", Font.BOLD, 15));
        submit.setSize(140, 30);
        submit.setLocation(600, 400);
        submit.setForeground(Color.BLACK);

        c.add(submit);
//        rent=new JButton("Retrieve rental report");
//        rent.setFont(new Font("Segoe UI", Font.BOLD,15));
//        rent.setSize(190, 30);
//        rent.setLocation(200, 450);
//        c.add(rent);
//        rent.setForeground(Color.BLACK);

//        JPanel panel = new JPanel();
//        ImageIcon image = new ImageIcon("hello.jpeg");
//        JLabel label = new JLabel(image);
//        c.add(label);

        JLabel pic=new JLabel(new ImageIcon("piu.jpg"));
        pic.setLocation(0,0);
        pic.setSize(800,500);
        c.add(pic);








        submit.addActionListener(this::actionPerformed);
        //  rent.addActionListener(this::actionPerformed);
        //rent.addActionListener(this::actionPerformed);



    }
    public void actionPerformed(ActionEvent lop)
    {
        if(lop.getSource()==submit)
        {
            w=txt1.getText();
            x=first.getText();

            y=Integer.parseInt(sec.getText());


            z=thr.getText();
            a=four.getText();









            upd();
        }

    }

    public void upd()
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
            System.out.println(y);
            Statement stmt=conn.createStatement();
            ResultSet rst=stmt.executeQuery("select * from property where property_ID="+y+";");
            int count=0;
            while(rst.next())
            {
                if(rst.getString(10).equals("NO") && rst.getString(11).equals("NO"))
                {
                    count++;

                }
            }


            if(count!=0) {
                String sql = "Insert into agent_buyer values(" + w + "," + x + "," + y + ",'" + z + "','"+a+"');";
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"Transaction successful!!");

            }
            else
            {
                JOptionPane.showMessageDialog(null,"Either this property is sold or on lease!!");

            }



        }
        catch (Exception e)
        {
            e.printStackTrace();
        }




        //   frame2.add(scroll);
        //  frame2.setVisible(true);




    }

    public static void main(String[] args) throws IOException {
        (new agent_buyer_update()).setVisible(true);

    }
}
