package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class DeletDetails extends JFrame implements ActionListener {

    JButton back;
    String username;
    DeletDetails(String username) {
        this.username = username;
        setBounds(450, 180, 870, 625);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel Iblusername = new JLabel("Username");
        Iblusername.setBounds(30, 50, 150, 25);
        add(Iblusername);

        JLabel labelusername = new JLabel();
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);

        JLabel Iblid = new JLabel("Id");
        Iblid.setBounds(30, 110, 150, 25);
        add(Iblid);

        JLabel labelid = new JLabel();
        labelid.setBounds(220, 110, 150, 25);
        add(labelid);

        JLabel Iblnumber = new JLabel("Number");
        Iblnumber.setBounds(30, 170, 150, 25);
        add(Iblnumber);

        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(220, 170, 150, 25);
        add(labelnumber);

        JLabel Iblname = new JLabel("Name");
        Iblname.setBounds(30, 230, 150, 25);
        add(Iblname);

        JLabel labelname = new JLabel();
        labelname.setBounds(220, 230, 150, 25);
        add(labelname);

        JLabel Iblgender = new JLabel("Gender");
        Iblgender.setBounds(30, 290, 150, 25);
        add(Iblgender);

        JLabel labelgender = new JLabel();
        labelgender.setBounds(220, 290, 150, 25);
        add(labelgender);

        JLabel Iblcountry = new JLabel("Country");
        Iblcountry.setBounds(500, 50, 150, 25);
        add(Iblcountry);

        JLabel labelcountry = new JLabel();
        labelcountry.setBounds(690, 50, 150, 25);
        add(labelcountry);

        JLabel Ibladdress = new JLabel("Address");
        Ibladdress.setBounds(500, 110, 150, 25);
        add(Ibladdress);

        JLabel labeladdress = new JLabel();
        labeladdress.setBounds(690, 110, 150, 25);
        add(labeladdress);

        JLabel Iblphone = new JLabel("Phone");
        Iblphone.setBounds(500, 170, 150, 25);
        add(Iblphone);

        JLabel labelphone = new JLabel();
        labelphone.setBounds(690, 170, 150, 25);
        add(labelphone);

        JLabel Iblemail = new JLabel("Email");
        Iblemail.setBounds(500, 230, 150, 25);
        add(Iblemail);

        JLabel labelemail = new JLabel();
        labelemail.setBounds(690, 230, 150, 25);
        add(labelemail);

        back = new JButton("Delete");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(350, 350, 100, 25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(20, 400, 600, 200);
        add(image);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i5 = i4.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(600, 400, 600, 200);
        add(image2);

        try {
            Conn conn = new Conn();
            String query = "select * from customer where username =  '" + username + "'";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelname.setText(rs.getString("name"));
                labelgender.setText(rs.getString("gender"));
                labelcountry.setText(rs.getString("country"));
                labeladdress.setText(rs.getString("address"));
                labelphone.setText(rs.getString("phone"));
                labelemail.setText(rs.getString("email"));

            }
        } catch (Exception e) {

        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            Conn c = new Conn();
            c.s.executeUpdate("delete from account where username ='"+username+"'");
            c.s.executeUpdate("delete from customer where username ='"+username+"'");
            c.s.executeUpdate("delete from bookpackage where username ='"+username+"'");
            c.s.executeUpdate("delete from bookhotal where username ='"+username+"'");
            
            
            JOptionPane.showMessageDialog(null, "Data Deleted Successfully");
            
            System.exit(0);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new DeletDetails("ManojKumar");
    }

}
