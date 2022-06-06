package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    
    Connection conn;
    public String hostname = "localhost";
    public String port = "3306";
    public String database = "abarrotesvictor";
    
    public String username = "root";
    public String password = "0858";
    
    public Connection getConnection() {
        try {
            String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";
            conn = DriverManager.getConnection(url, username, password);
            return conn;
        } catch (SQLException e) {
            System.err.println(e.toString());
        }
        return null;
    }
    
}
