
package travel.management.system;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {

    Connection c;
    Statement s;
    Conn() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelmanagement", "root", "MaNOJ%@8650");
            s = c.createStatement();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

