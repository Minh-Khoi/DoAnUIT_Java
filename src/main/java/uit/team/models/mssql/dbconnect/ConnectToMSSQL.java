/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.team.models.mssql.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class ConnectToMSSQL {
    private static final String url = "jdbc:sqlserver://DESKTOP-7VC9MRJ\\SQLEXPRESS:1433;databaseName=QuanlyThuvien;"
                                       + "encrypt=true;trustServerCertificate=true";
    private static final String username = "sa";
    private static final String password = "123456";
    static Connection conn ;
    static {
        try {
            conn = getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectToMSSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("Driver not found!");
        }
    }
    
    public static Connection getConn(){
        return conn;
    }
    
    
//    public static void main(String[] args) throws SQLException {
//        Connection conn = getConnection();
//        System.out.println(conn.getCatalog());
//        conn.close(); // Remember to close the connection after use
//    }
}
