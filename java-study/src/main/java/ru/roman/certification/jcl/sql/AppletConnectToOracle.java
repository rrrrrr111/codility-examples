package ru.roman.certification.jcl.sql;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class AppletConnectToOracle extends JApplet {

    private JButton DbConnect = new JButton();
    private JTextArea empValues = new JTextArea();
    private Connection con;
    private JLabel jLabel1 = new JLabel();

    public AppletConnectToOracle() {
    }

    @Override
    public void init() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout(null);
        DbConnect.setText("Click to Connect to DB");
        DbConnect.setBounds(new Rectangle(90, 225, 175, 40));
        DbConnect.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                connectToDB(e);
            }
        });
        empValues.setBounds(new Rectangle(40, 50, 310, 150));
        jLabel1.setText("Emp Records :");
        jLabel1.setBounds(new Rectangle(45, 20, 155, 20));
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(empValues, null);
        this.getContentPane().add(DbConnect, null);
    }

    private void connectToDB(ActionEvent e) {
        try {
            //DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            //con = DriverManager.getConnection("jdbc:oracle:thin:@bank111:1521:bank111","gc","gc");
            //DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            con = DriverManager.getConnection("jdbc:odbc:BSS_TREN", "dba", "sql");
            empValues.setText("Connected to the Database.Fetching Values from DEPT Tables.\n");
            fetchValues();
        } catch (SQLException ex) {
            System.out.println("Connection Error =  " + ex.toString());
        }
    }

    public void fetchValues() {
        try {
            Statement stmt = con.createStatement();
            StringBuffer allRowValues = new StringBuffer();
            int counter = 1;
            ResultSet rset = stmt.executeQuery("select * from account");
            //ResultSet rset = stmt.executeQuery("select s, dlast0 from GC.ACC where ACC.s = 2629 or ACC.s = 2630");
            while (rset.next()) {
                allRowValues.append("Row " + counter + " 1col=" + rset.getString(1) + " 2col=" + rset.getString(2) + "\n");
                counter++;
            }
            empValues.setText(allRowValues.toString());
            rset.close();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("Error While Fetching Values =  " + ex.toString());
        }
    }
}
