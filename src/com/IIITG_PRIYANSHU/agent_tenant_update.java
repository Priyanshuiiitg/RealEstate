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

public class agent_tenant_update extends JFrame {
    private JLabel heading;
    private JTextField txt1;

    private JTextField first;

    private JTextField sec;
    private JTextField thr;
    private JTextField thr1;
    private JTextField end;
    private JTextField end1;





    private JButton submit;
    private JButton rent;
    private JTable table;
    private JFrame frame2;
    String w,x;
    int y;
    String z="",a="",b="",ca="";
    String[] columnNames = {"ID", "Name", "Standing", "Major","Age"};

    private JLabel agent;
    private Container c;
    public agent_tenant_update() throws IOException {




        setTitle("Transaction");
        setBounds(300,90,800,536);
      //  setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        c=getContentPane();
        c.setLayout(null);
        heading =new JLabel("Agent Tenant transaction update");
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
        JLabel by=new JLabel("Tenant's Aadhaar No ");
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
        JLabel syr=new JLabel("Starting year ");
        syr.setFont(new Font("Segoe UI", Font.BOLD,20));
        syr.setSize(200, 40);
        syr.setLocation(100, 320);
        syr.setForeground(Color.WHITE);
        c.add(syr);
        JLabel sdt=new JLabel("Starting date");
        sdt.setFont(new Font("Segoe UI", Font.BOLD,20));
        sdt.setSize(160, 40);
        sdt.setLocation(420, 320);
        sdt.setForeground(Color.WHITE);
        c.add(sdt);

        JLabel eyr=new JLabel("End year");
        eyr.setFont(new Font("Segoe UI", Font.BOLD,20));
        eyr.setSize(200, 40);
        eyr.setLocation(100, 380);
        eyr.setForeground(Color.WHITE);
        c.add(eyr);
        JLabel edt=new JLabel("End date");
        edt.setFont(new Font("Segoe UI", Font.BOLD,20));
        edt.setSize(200, 40);
        edt.setLocation(420, 380);
        edt.setForeground(Color.WHITE);
        c.add(edt);







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
        thr.setSize(80, 30);
        thr.setLocation(320, 320);
        c.add(thr);
        thr1=new JTextField();
        thr1.setFont(new Font("Segoe UI", Font.BOLD,15));
        thr1.setSize(120, 30);
        thr1.setLocation(580, 320);
        c.add(thr1);

    end=new JTextField();
        end.setFont(new Font("Segoe UI", Font.BOLD,15));
        end.setSize(80, 30);
        end.setLocation(320, 380);
        c.add(end);
        end1=new JTextField();
        end1.setFont(new Font("Segoe UI", Font.BOLD,15));
        end1.setSize(120, 30);
        end1.setLocation(580, 380);
        c.add(end1);








        submit=new JButton("Update");
        submit.setFont(new Font("Segoe UI", Font.BOLD, 15));
        submit.setSize(140, 30);
        submit.setLocation(300, 450);
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
            a=end.getText();
            b=thr1.getText();
            ca=end1.getText();











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
            Statement stmt=conn.createStatement();
            int count=0;
            ResultSet rst=stmt.executeQuery("select * from property where property_ID="+y+";");
            while(rst.next())
            {
                if(rst.getString(10).equals("NO") && rst.getString(11).equals("NO"))
                {
                    count++;

                }
            }
            if(count!=0) {
                String sql = "Insert into agent_tenant values(" + w + "," + x + "," + y + ",'" + z + "','" + a + "','" + b +"','" + ca +"');";
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
        (new agent_tenant_update()).setVisible(true);

    }
}
