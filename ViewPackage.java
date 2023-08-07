package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewPackage extends JFrame implements ActionListener {

    JButton back;

    ViewPackage(String username) {
        setBounds(450, 200, 900, 455);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("VIEW PACKAGE DETAILS");
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        text.setBounds(60, 0, 300, 30);
        add(text);

        JLabel Iblusername = new JLabel("Username");
        Iblusername.setBounds(30, 50, 150, 25);
        add(Iblusername);

        JLabel labelusername = new JLabel();
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);

        JLabel Iblid = new JLabel("Package");
        Iblid.setBounds(30, 90, 150, 25);
        add(Iblid);

        JLabel labelpackage = new JLabel();
        labelpackage.setBounds(220, 90, 150, 25);
        add(labelpackage);

        JLabel Iblnumber = new JLabel("Total Persons");
        Iblnumber.setBounds(30, 130, 150, 25);
        add(Iblnumber);

        JLabel labelpersons = new JLabel();
        labelpersons.setBounds(220, 130, 150, 25);
        add(labelpersons);

        JLabel Iblname = new JLabel("Id");
        Iblname.setBounds(30, 170, 150, 25);
        add(Iblname);

        JLabel labelid = new JLabel();
        labelid.setBounds(220, 170, 150, 25);
        add(labelid);

        JLabel Iblgender = new JLabel("Number");
        Iblgender.setBounds(30, 210, 150, 25);
        add(Iblgender);

        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(220, 210, 150, 25);
        add(labelnumber);

        JLabel Iblcountry = new JLabel("Phone");
        Iblcountry.setBounds(30, 250, 150, 25);
        add(Iblcountry);

        JLabel labelphone = new JLabel();
        labelphone.setBounds(220, 250, 150, 25);
        add(labelphone);

        JLabel Ibladdress = new JLabel("Price");
        Ibladdress.setBounds(30, 290, 150, 25);
        add(Ibladdress);

        JLabel labelprice = new JLabel();
        labelprice.setBounds(220, 290, 150, 25);
        add(labelprice);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(130, 360, 100, 25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 20, 500, 400);
        add(image);

   
        try {
            Conn conn = new Conn();
            String query = "select * from bookpackage where username =  '" + username + "'";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelpackage.setText(rs.getString("package"));
                labelprice.setText(rs.getString("price"));
                labelpersons.setText(rs.getString("persons"));
                labelphone.setText(rs.getString("phone"));

            }
        } catch (Exception e) {

        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new ViewPackage("ManojKumar");
    }

}
