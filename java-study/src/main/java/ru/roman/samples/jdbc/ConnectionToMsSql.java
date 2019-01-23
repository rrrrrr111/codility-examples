package ru.roman.samples.jdbc;


import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;

class ConnectionToMsSql {

    public static void main(String args[]) {
        String query = "SELECT * FROM branches";
        String[] colHeads;
        Object[][] data;
        try {

            //Class.forName ("com.microsoft.jdbc.sqlserver.SQLServerDriver");
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            DriverManager.setLogStream(System.out);
            Connection con = DriverManager.getConnection("jdbc:odbc:BSS_TREN", "dba", "sql");
            checkForWarning(con.getWarnings());

            DatabaseMetaData dma = con.getMetaData();
            System.out.println("\nConnected to " + dma.getURL());
            System.out.println("Driver       " + dma.getDriverName());
            System.out.println("Version      " + dma.getDriverVersion());
            System.out.println("");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            dispResultSet(rs);
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("\n*** SQLException ***\n");
            while (ex != null) {
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("Message:  " + ex.getMessage());
                System.out.println("Vendor:   " + ex.getErrorCode());
                ex = ex.getNextException();
                System.out.println("");
            }
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
        }
    }


    private static boolean checkForWarning(SQLWarning warn)
            throws SQLException {
        boolean rc = false;
        if (warn != null) {
            System.out.println("\n *** Warning ***\n");
            rc = true;
            while (warn != null) {
                System.out.println("SQLState: " + warn.getSQLState());
                System.out.println("Message:  " + warn.getMessage());
                System.out.println("Vendor:   " + warn.getErrorCode());
                System.out.println("");
                warn = warn.getNextWarning();
            }
        }
        return rc;
    }

    private static void dispResultSet(ResultSet rs) throws SQLException {
        int i;

        ResultSetMetaData rsmd = rs.getMetaData();
        int numCols = rsmd.getColumnCount();
        for (i = 1; i <= numCols; i++) {
            System.out.print(rsmd.getColumnLabel(i));
        }
        System.out.println("");

        boolean more = rs.next();
        while (more) {
            for (i = 1; i <= numCols; i++) {
                if (i > 1) {
                    System.out.print(",");
                }
                System.out.print(rs.getString(i));
            }
            System.out.println("");
            more = rs.next();
        }
    }
}
