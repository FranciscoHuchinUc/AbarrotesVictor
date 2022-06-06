package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAO {
    
    Connection conn;
    MySQLConnection cn = new MySQLConnection();
    PreparedStatement ps;
    ResultSet rs;
    
    public List listarProvvedor(){
        List<Proveedor> listaPr = new ArrayList();
        String query = "SELECT * FROM proveedor";
        try {
            conn = cn.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Proveedor pr = new Proveedor();
                pr.setRfc(rs.getString("rfc"));
                pr.setNombre(rs.getString("nombre"));
                pr.setDireccion(rs.getString("direccion"));
                pr.setTelefono(rs.getString("telefono"));
                listaPr.add(pr);
            }
        } catch (SQLException e) {
            System.err.println(e.toString());
        }
        return listaPr;
    }
    
    public boolean registrarProveedor(Proveedor pr) {
        String query = "INSERT INTO proveedor(rfc, nombre, direccion, telefono) VALUES (?,?,?,?)";
        try {
            conn = cn.getConnection();
            ps = conn.prepareStatement(query);
            
            ps.setString(1, pr.getRfc());
            ps.setString(2, pr.getNombre());
            ps.setString(3, pr.getDireccion());
            ps.setString(4, pr.getTelefono());
            ps.execute();
            return true;
            
        } catch (SQLException e) {
            System.err.println(e.toString());
            return  false;
        } finally {
            try{
                conn.close();
            } catch (SQLException e){
                System.err.println(e.toString());
            }
        }
    }
    
    public boolean eliminarProveedor(String rfc){
        String query = "DELETE FROM proveedor WHERE rfc=?";
        try {
            conn = cn.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, rfc);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e.toString());
            return false;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println(e.toString());
            }
        }
    }
    
    public boolean modificarProveedor(Proveedor pr){
        String query = "UPDATE proveedor SET nombre=?, direccion=?, telefono=? WHERE rfc=?";
        try {
            conn = cn.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, pr.getNombre());
            ps.setString(2, pr.getDireccion());
            ps.setString(3, pr.getTelefono());
            ps.setString(4, pr.getRfc());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e.toString());
            return false;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println(e.toString());
            }
        }
    }
    
}
