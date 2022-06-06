package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthDAO {
    
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    MySQLConnection cn = new MySQLConnection();
    
    public Auth log(String nombre, String pass){
        Auth l = new Auth();
        String query = "SELECT * FROM usuarios WHERE curp=? AND pass=?";
        try {
            conn = cn.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, nombre);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if (rs.next()){
                l.setId(rs.getInt("id"));
                l.setCurp(rs.getString("curp"));
                l.setPass(rs.getString("pass"));
            }
        } catch (SQLException e) {
            System.err.println(e.toString());
        }
        return l;
    }
    
}
