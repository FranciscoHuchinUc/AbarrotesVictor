package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VentaDAO {
    
    Connection conn;
    MySQLConnection cn = new MySQLConnection();
    PreparedStatement ps;
    ResultSet rs;
    int result;
    
    public int idVenta() {
        int id = 0;
        String query = "SELECT MAX(id) FROM ventas";
        try {
            conn = cn.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            if(rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println(e.toString());
        }
        return id;
    }
    
    public List listarVenta(){
        List<Venta> listaVenta = new ArrayList();
        String query = "SELECT * FROM ventas";
        try {
            conn = cn.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Venta vent = new Venta();
                vent.setId(rs.getInt("id"));
                vent.setVendedor(rs.getString("vendedor"));
                vent.setTotal(rs.getInt("total"));
                listaVenta.add(vent);
            }
        } catch (SQLException e) {
            System.err.println(e.toString());
        }
        return listaVenta;
    }
    
    public int registrarVenta(Venta v){
        String query = "INSERT INTO ventas(vendedor, total) VALUES (?,?)";
        try {
            conn = cn.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, v.getVendedor());
            ps.setDouble(2, v.getTotal());
            ps.execute();
        } catch (SQLException e) {
            System.err.println(e.toString());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println(e.toString());
            }
        }
        return result;
    }
    
    public int registrarDetalle(Detalle dv) {
        String query = "INSERT INTO detalle(cod_prod, cantidad, precio, id_venta) VALUES (?,?,?,?)";
        try {
            conn = cn.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, dv.getCod_prod());
            ps.setInt(2, dv.getCantidad());
            ps.setDouble(3, dv.getPrecio());
            ps.setInt(4, dv.getId_venta());
            ps.execute();
        } catch (SQLException e) {
            System.err.println(e.toString());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println(e.toString());
            }
        }
        return result;
    }
    
    public boolean actualizarStock(int cant, String codigo) {
        String query = "UPDATE productos SET stock=? WHERE codigo=?";
        try {
            conn= cn.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, cant);
            ps.setString(2, codigo);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e.toString());
            return false;
        }
    }
    
}
