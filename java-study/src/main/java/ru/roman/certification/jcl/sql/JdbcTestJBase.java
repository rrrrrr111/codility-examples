package ru.roman.certification.jcl.sql;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class JdbcTestJBase {

    public static void main(String args[]) throws SQLException, IOException {
        System.out.println("Loading jdbc jBASE driver");
        try {
            Class.forName("com.jbase.jdbc.driver.JBaseJDBCDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load the driver. Is your classpath correct?");
            e.printStackTrace();
        }
        System.out.println("Connecting to the local database");
        Connection conn =
                DriverManager.getConnection("jdbc:jbasejo:thin:@mhqsa063:3570:BNK", "r6test1", "123456");
        try {
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("SELECT @ID, SHORT_NAME FROM F_CUSTOMER");
//rset.next();
            while (rset.next()) {
// Print the name out
                String lastName = rset.getString(1);
                System.out.println("Thirst row " + lastName + "\n   ");
            }
            stmt.close();

            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
            System.out.println("..........................");
            String sErrorState = "Err Code: " + se.getErrorCode() +
                    " SQL State: " + se.getSQLState() + " mesg: " + se.getMessage();
            System.out.println(sErrorState);
            System.out.println("..........................");
            conn.close();
        }
    }
}


