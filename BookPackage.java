package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class BookPackage extends JFrame implements ActionListener {

    Choice cpackage;
    JTextField tfpersons;
    String username;
    JLabel labelusername, labelid, labelnumber, labelphone, labelprice;
    JButton checkprice, bookpackage, back;

    BookPackage(String username) {
        this.username = username;
        setBounds(350, 200, 1100, 500);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("BOOK PACKAGE");
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

        JLabel Iblpackage = new JLabel("Select Package");
        Iblpackage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        Iblpackage.setBounds(40, 110, 200, 20);
        add(Iblpackage);

        cpackage = new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");
        cpackage.setBounds(250, 110, 200, 20);
        add(cpackage);

        JLabel Iblpersons = new JLabel("Total Persons");
        Iblpersons.setFont(new Font("Tahoma", Font.PLAIN, 16));
        Iblpersons.setBounds(40, 150, 150, 25);
        add(Iblpersons);

        tfpersons = new JTextField("1");
        tfpersons.setBounds(250, 150, 200, 25);
        add(tfpersons);

        JLabel Iblid = new JLabel("Id");
        Iblid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        Iblid.setBounds(40, 190, 150, 20);
        add(Iblid);

        labelid = new JLabel();
        labelid.setBounds(250, 190, 200, 25);
        add(labelid);

        JLabel Iblnumber = new JLabel("Number");
        Iblnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        Iblnumber.setBounds(40, 230, 150, 25);
        add(Iblnumber);

        labelnumber = new JLabel();
        labelnumber.setBounds(250, 230, 150, 25);
        add(labelnumber);

        JLabel Iblphone = new JLabel("Phone");
        Iblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        Iblphone.setBounds(40, 270, 200, 20);
        add(Iblphone);

        labelphone = new JLabel();
        labelphone.setBounds(250, 270, 200, 25);
        add(labelphone);

        JLabel Ibltotal = new JLabel("Total Price");
        Ibltotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        Ibltotal.setBounds(40, 310, 150, 25);
        add(Ibltotal);

        labelprice = new JLabel();
        labelprice.setBounds(250, 310, 150, 25);
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
        checkprice.setBounds(60, 380, 120, 25);
        checkprice.addActionListener(this);
        add(checkprice);

        bookpackage = new JButton("Book Package");
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setBounds(200, 380, 120, 25);
        bookpackage.addActionListener(this);
        add(bookpackage);

        back = new JButton("Back");
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(340, 380, 120, 25);
        back.addActionListener(this);
        add(back);
        
        
           ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550, 50, 500, 300);
        add(image);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkprice) {
            String pack = cpackage.getSelectedItem();
            int cost = 0;
            if (pack.equals("Gold Package")) {
                cost += 12000;
            } else if (pack.equals("Silver Package")) {
                cost += 24000;
            } else {
                cost += 36000;
            }
            int persons = Integer.parseInt(tfpersons.getText());
            cost *= persons;
            labelprice.setText("Rs " + cost);

        } else if (ae.getSource() == bookpackage) {
            try {
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookpackage values('" + labelusername.getText() + "', '" + cpackage.getSelectedItem() + "', '" + tfpersons.getText() + "',  '" + labelid.getText() + "', '" + labelnumber.getText() + "', '" + labelphone.getText() + "', '" + labelprice.getText() + "')");

                JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new BookPackage("ManojKumar");
    }
}
