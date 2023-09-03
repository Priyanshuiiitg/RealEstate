package com.IIITG_PRIYANSHU;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class start extends JFrame {
    private JLabel heading;
    private JTextField txt1;
    private JButton f1,f2,f3,f4,f5,f6;
  //  private JButton rent;
    private JTable table;
    private JFrame frame2;
    int id;
    String[] columnNames = {"ID", "Name", "Standing", "Major","Age"};

    private JLabel agent;
    private Container c;
    public start() {




        setTitle("Welcome to central distribution software");
        setBounds(300,90,800,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        c=getContentPane();
        c.setLayout(null);
        heading =new JLabel("Welcome!!");
        heading.setFont(new Font("Segoe UI", Font.BOLD,30));
        heading.setForeground(Color.WHITE);
//c.setBackground(Color.DARK_GRAY);


        heading.setSize(600, 37);
        heading.setLocation(330, 30);
        c.add(heading);

        f1=new JButton("Agent Buyer");
        f1.setFont(new Font("Segoe UI", Font.BOLD, 15));
        f1.setSize(190, 30);
        f1.setLocation(180, 200);
        f1.setForeground(Color.BLACK);

        c.add(f1);
        f2=new JButton("Agent Tenant");
        f2.setFont(new Font("Segoe UI", Font.BOLD,15));
        f2.setSize(190, 30);
        f2.setLocation(400, 200);
        c.add(f2);
        f2.setForeground(Color.BLACK);

        f3=new JButton("Admin Login");
        f3.setFont(new Font("Segoe UI", Font.BOLD, 15));
        f3.setSize(190, 30);
        f3.setLocation(180, 130);
        f3.setForeground(Color.BLACK);

        c.add(f3);

        f4=new JButton("Real estate office");
        f4.setFont(new Font("Segoe UI", Font.BOLD, 15));
        f4.setSize(190, 30);
        f4.setLocation(400, 130);
        f4.setForeground(Color.BLACK);

        c.add(f4);
        f5=new JButton("Buyers");
        f5.setFont(new Font("Segoe UI", Font.BOLD, 15));
        f5.setSize(190, 30);
        f5.setLocation(180, 270);
        f5.setForeground(Color.BLACK);

        c.add(f5);
        f6=new JButton("Tenants");
        f6.setFont(new Font("Segoe UI", Font.BOLD, 15));
        f6.setSize(190, 30);
        f6.setLocation(400, 270);
        f6.setForeground(Color.BLACK);

        c.add(f6);

//        JPanel panel = new JPanel();
//        ImageIcon image = new ImageIcon("hello.jpeg");
//        JLabel label = new JLabel(image);
//        c.add(label);

        JLabel pic=new JLabel(new ImageIcon("start.jpg"));
        pic.setLocation(0,0);
        pic.setSize(800,500);
        c.add(pic);








    f1.addActionListener(this::actionPerformed);

        f2.addActionListener(this::actionPerformed);
        f3.addActionListener(this::actionPerformed);

        f4.addActionListener(this::actionPerformed);
        f5.addActionListener(this::actionPerformed);
        f6.addActionListener(this::actionPerformed);


        //rent.addActionListener(this::actionPerformed);



    }
    public void actionPerformed(ActionEvent first)  {
        if(first.getSource()==f1)
        {
            agent_login.main(null);

        }
        if(first.getSource()==f2)
        {
           agent_tl.main(null);
        }
        if(first.getSource()==f3)
        {
            admin_login.main(null);


        }
        if(first.getSource()==f4)
        {
            try {
                (new RealEstateOfficeGUI()).setVisible(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(first.getSource()==f5)
        {
            try {
                buyer_update.main(null);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
        if(first.getSource()==f6)
        {
            try{
               tenant_update.main(null);

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

    }

    public void showTable()
    {
        frame2=new JFrame("Database search Result");
        frame2.setBounds(200,200,900,300);
        frame2.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame2.setResizable(false);

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        //DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames());
        // table = new JTable(model);
        table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
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


            String url = "jdbc:mysql://localhost:3306/central";
            Connection conn = DriverManager.getConnection(url, "root", pass);
            PreparedStatement st=conn.prepareStatement("Select * from student where age="+id+";");
            ResultSet rs=st.executeQuery();
            int i=0;
            while(rs.next())
            {
                i++;

                model.addRow(new Object[]{rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
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
            e.printStackTrace();
        }




        frame2.add(scroll);
        //  frame2.setVisible(true);




    }

    public static void main(String[] args) throws IOException {
        (new start()).setVisible(true);

    }
}
