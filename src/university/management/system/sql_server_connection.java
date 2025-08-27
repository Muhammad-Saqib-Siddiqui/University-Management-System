//package university.management.system;
//import java.sql.*;
//
//public class sql_server_connection {
//
//    sql_server_connection() {
//        Connection conn = null;
//
//        try {
//            // Load the SQL Server JDBC driver
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//
//            // Connection string using SQL Server Authentication
//            String dbURL = "jdbc:sqlserver://localhost:1440;databaseName=E_learning;user=waqar;password=waqar123;encrypt=true;trustServerCertificate=true";
//
//            // Connect to the database
//            conn = DriverManager.getConnection(dbURL);
//
//            if (conn != null) {
//                DatabaseMetaData dm = conn.getMetaData();
//                System.out.println("Connected with SQL Server Authentication:");
//                System.out.println("Driver Name: " + dm.getDriverName());
//                System.out.println("Database Product: " + dm.getDatabaseProductName());
//            }
//
//        } catch (ClassNotFoundException e) {
//            System.out.println("JDBC Driver not found.");
//            e.printStackTrace();
//        } catch (SQLException e) {
//            System.out.println("Connection failed.");
//            e.printStackTrace();
//        } finally {
//            try {
//                if (conn != null && !conn.isClosed()) {
//                    conn.close();
//                    System.out.println("Connection closed.");
//                }
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        new sql_server_connection();
//    }
//}

package university.management.system;

import java.sql.*;

public class sql_server_connection {

    public Connection conn;
    public Statement s;

    public sql_server_connection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String dbURL = "jdbc:sqlserver://localhost:1440;databaseName=E_learning;"
                         + "user=sa;password=saqib123;encrypt=true;trustServerCertificate=true";

            conn = DriverManager.getConnection(dbURL);
            s = conn.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
public static void main(String[]args){
   
sql_server_connection con = new sql_server_connection();
    }     
}


