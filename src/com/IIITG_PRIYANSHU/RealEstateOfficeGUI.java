package com.IIITG_PRIYANSHU;
import com.mysql.cj.jdbc.result.ResultSetMetaData;

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

public class RealEstateOfficeGUI extends JFrame {
    private JLabel heading;
    private JTextField txt1;
    private JButton submit;
    private JButton rent;
    private JTable table;
    private JFrame frame2;
 String id;
 int check=-1;
    String[] columnNames = {"ID", "Name", "Standing", "Major","Age"};

    private JLabel agent;
    private Container c;
    public RealEstateOfficeGUI() throws IOException {




        setTitle("Real Estate Office");
       setBounds(300,90,800,500);
     //   setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        c=getContentPane();
        c.setLayout(null);
        heading =new JLabel("Welcome to our Real Estate Office!!");
        heading.setFont(new Font("Segoe UI", Font.BOLD,30));
  heading.setForeground(Color.WHITE);
//c.setBackground(Color.DARK_GRAY);


        heading.setSize(600, 30);
        heading.setLocation(200, 30);
        c.add(heading);
        agent = new JLabel("Agent ID");
        agent.setFont(new Font("Segoe UI", Font.BOLD,20));
        agent.setSize(100, 40);
        agent.setLocation(100, 140);
        agent.setForeground(Color.WHITE);
        c.add(agent);
        txt1 = new JTextField();
        txt1.setFont(new Font("Segoe UI", Font.BOLD,15));
        txt1.setSize(190, 30);
        txt1.setLocation(200, 140);
        c.add(txt1);
        submit=new JButton("Retrieve sales report");
        submit.setFont(new Font("Segoe UI", Font.BOLD, 15));
        submit.setSize(190, 30);
        submit.setLocation(200, 200);
        submit.setForeground(Color.BLACK);

        c.add(submit);
        rent=new JButton("Retrieve rental report");
        rent.setFont(new Font("Segoe UI", Font.BOLD,15));
        rent.setSize(190, 30);
        rent.setLocation(200, 250);
        c.add(rent);
        rent.setForeground(Color.BLACK);

//        JPanel panel = new JPanel();
//        ImageIcon image = new ImageIcon("hello.jpeg");
//        JLabel label = new JLabel(image);
//        c.add(label);

JLabel pic=new JLabel(new ImageIcon("hell.jpg"));
pic.setLocation(0,0);
pic.setSize(800,500);
c.add(pic);








        submit.addActionListener(this::actionPerformed);
        rent.addActionListener(this::actionPerformed);
    //rent.addActionListener(this::actionPerformed);



    }
    public void actionPerformed(ActionEvent first)
    {
        if(first.getSource()==submit)
        {
            id=txt1.getText();
            check=0;

            showTable();
        }
        if(first.getSource()==rent)
        {
          id=txt1.getText();
          check=1;

            showTable();
        }
    }

    public void showTable()
    {
        frame2=new JFrame("Database search Result");
       frame2.setBounds(200,200,900,300);
       frame2.setDefaultCloseOperation(EXIT_ON_CLOSE);
       frame2.setResizable(false);

        DefaultTableModel model = new DefaultTableModel();
    //    model.setColumnIdentifiers(columnNames);
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



            String url = "jdbc:mysql://localhost:3306/real_estate";
            Connection conn = DriverManager.getConnection(url, "root", pass);
            PreparedStatement st;
            if(check==0)
             st=conn.prepareStatement("select property_address.*,agent_aadhaar_number,buyer_aadhaar_number,year_of_transaction,day_of_transaction,selling_price from agent_buyer,property_address,property where agent_aadhaar_number="+id+" and property_address.property_ID=agent_buyer.property_ID and property.property_ID=agent_buyer.property_ID and property.property_ID=property_address.property_ID;");
            else
                st=conn.prepareStatement("select property_address.*,agent_aadhaar_number,tenant_aadhaar_number,start_year_of_contract,end_year_of_contract,start_day_of_contract,end_day_of_contract,selling_price from agent_tenant,property_address,property where agent_aadhaar_number="+id+" and property_address.property_ID=agent_tenant.property_ID and property.property_ID=agent_tenant.property_ID and property.property_ID=property_address.property_ID;");

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
            e.printStackTrace();
        }




frame2.add(scroll);
      //  frame2.setVisible(true);




    }

    public static void main(String[] args) throws IOException {
        (new RealEstateOfficeGUI()).setVisible(true);

    }
}
