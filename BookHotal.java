package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class BookHotal extends JFrame implements ActionListener {

    Choice chotal, cac, cfood;
    JTextField tfpersons, tfdays;
    String username;
    JLabel labelusername, labelid, labelnumber, labelphone, labelprice;
    JButton checkprice, bookpackage, back;

    BookHotal(String username) {
        this.username = username;
        setBounds(350, 200, 1100, 600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("BOOK HOTAL");
        text.setBounds(100, 10, 200, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);

        JLabel Iblusername = new JLabel("Username");
        Iblusername.setBounds(40, 70, 100, 20);
        Iblusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(Iblusername);

        labelusername = new JLabel();
        labelusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelusername.setBounds(250, 70, 150, 20);
        add(labelusername);

        JLabel Iblpackage = new JLabel("Select Hotal");
        Iblpackage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        Iblpackage.setBounds(40, 110, 200, 20);
        add(Iblpackage);

        chotal = new Choice();
        chotal.setBounds(250, 110, 200, 20);
        add(chotal);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotal");
            while (rs.next()) {
                chotal.add(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel Iblpersons = new JLabel("Total Persons");
        Iblpersons.setFont(new Font("Tahoma", Font.PLAIN, 16));
        Iblpersons.setBounds(40, 150, 150, 25);
        add(Iblpersons);

        tfpersons = new JTextField("1");
        tfpersons.setBounds(250, 150, 200, 25);
        add(tfpersons);

        JLabel Ibldays = new JLabel("No. of Days");
        Ibldays.setFont(new Font("Tahoma", Font.PLAIN, 16));
        Ibldays.setBounds(40, 190, 150, 25);
        add(Ibldays);

        tfdays = new JTextField("1");
        tfdays.setBounds(250, 190, 200, 25);
        add(tfdays);

        JLabel Iblac = new JLabel("AC/ Non-AC");
        Iblac.setFont(new Font("Tahoma", Font.PLAIN, 16));
        Iblac.setBounds(40, 230, 150, 25);
        add(Iblac);

        cac = new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(250, 230, 200, 20);
        add(cac);

        JLabel Iblfood = new JLabel("Foood Included");
        Iblfood.setFont(new Font("Tahoma", Font.PLAIN, 16));
        Iblfood.setBounds(40, 270, 150, 25);
        add(Iblfood);

        cfood = new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(250, 270, 200, 20);
        add(cfood);

        JLabel Iblid = new JLabel("Id");
        Iblid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        Iblid.setBounds(40, 310, 150, 20);
        add(Iblid);

        labelid = new JLabel();
        labelid.setBounds(250, 310, 200, 25);
        add(labelid);

        JLabel Iblnumber = new JLabel("Number");
        Iblnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        Iblnumber.setBounds(40, 350, 150, 25);
        add(Iblnumber);

        labelnumber = new JLabel();
        labelnumber.setBounds(250, 350, 150, 25);
        add(labelnumber);

        JLabel Iblphone = new JLabel("Phone");
        Iblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        Iblphone.setBounds(40, 390, 200, 20);
        add(Iblphone);

        labelphone = new JLabel();
        labelphone.setBounds(250, 390, 200, 25);
        add(labelphone);

        JLabel Ibltotal = new JLabel("Total Price");
        Ibltotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        Ibltotal.setBounds(40, 430, 150, 25);
        add(Ibltotal);

        labelprice = new JLabel();
        labelprice.setBounds(250, 430, 150, 25);
        add(labelprice);

        try {
            Conn conn = new Conn();
            String query = "select * from customer where username =  '" + username + "'";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        checkprice = new JButton("Check Price");
        checkprice.setForeground(Color.WHITE);
        checkprice.setBackground(Color.BLACK);
        checkprice.setBounds(60, 490, 120, 25);
        checkprice.addActionListener(this);
        add(checkprice);

        bookpackage = new JButton("Book Hotal");
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setBounds(200, 490, 120, 25);
        bookpackage.addActionListener(this);
        add(bookpackage);

        back = new JButton("Back");
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(340, 490, 120, 25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 50, 600, 400);
        add(image);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkprice) {
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from hotal where name ='" + chotal.getSelectedItem() + "'");
                while (rs.next()) {
                    int cost = Integer.parseInt(rs.getString("costperperson"));
                    int food = Integer.parseInt(rs.getString("foodincluded"));
                    int ac = Integer.parseInt(rs.getString("acroom"));
                    
                    int persons = Integer.parseInt(tfpersons.getText());
                    int days = Integer.parseInt(tfdays.getText());
                    
                    String acselected = cac.getSelectedItem();
                    String foodselected = cfood.getSelectedItem();
                    
                    if (persons * days > 0) {
                        int total = 0;
                        total += acselected.equals("AC") ? ac : 0;
                        total += foodselected.equals("Yes") ? food : 0;
                        total += cost;
                        total = total * persons * days;
                        labelprice.setText("Rs. " + total);
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter a valid Number");
                    }

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == bookpackage) {
            try {
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookhotal values('" + labelusername.getText() + "', '"+ chotal.getSelectedItem() + "', '" + tfpersons.getText() + "', '"+ tfdays.getText() + "',  '"+cac.getSelectedItem()+"', '"+cfood.getSelectedItem()+"', '" + labelid.getText() + "', '" + labelnumber.getText() + "', '" + labelphone.getText() + "', '" + labelprice.getText() + "')");

                JOptionPane.showMessageDialog(null, "Hotal Booked Successfully");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new BookHotal("ManojKumar");
    }
}
