package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

public class ProductoDAO {
    
    Connection conn;
    MySQLConnection cn = new MySQLConnection();
    PreparedStatement ps;
    ResultSet rs;
    
    public List listarProducto(){
        List<Producto> listaPr = new ArrayList();
        String query = "SELECT * FROM productos";
        try {
            conn = cn.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto pd = new Producto();
                pd.setCodigo(rs.getString("codigo"));
                pd.setNombre(rs.getString("nombre"));
                pd.setStock(rs.getInt("stock"));
                pd.setPrecio(rs.getDouble("precio"));
                pd.setProveedor(rs.getString("proveedor"));
                listaPr.add(pd);
            }
        } catch (SQLException e) {
            System.err.println(e.toString());
        }
        return listaPr;
    }
    
    public boolean registrarProducto(Producto pd){
        String query = "INSERT INTO productos (codigo, nombre, stock, precio, proveedor) VALUES (?,?,?,?,?)";
        try {
            conn = cn.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, pd.getCodigo());
            ps.setString(2, pd.getNombre());
            ps.setInt(3, pd.getStock());
            ps.setDouble(4, pd.getPrecio());
            ps.setString(5, pd.getProveedor());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e.toString());
            return false;
        } finally {
            try{
                conn.close();
            } catch (SQLException e){
                System.err.println(e.toString());
            }
        }
    }
    
    public void consultarProveedor(JComboBox proveedor) {
        String query = "SELECT nombre FROM proveedor";
        try {
            conn = cn.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {                
                proveedor.addItem(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.err.println(e.toString());
        }
    }
    
    public boolean eliminarProducto(String codigo) {
        String query = "DELETE FROM productos WHERE codigo=?";
        try {
            conn = cn.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, codigo);
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
    
    public boolean modificarProducto(Producto pd){
        String query = "UPDATE productos SET nombre=?, stock=?, precio=?, proveedor=? WHERE codigo=?";
        try {
            conn = cn.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, pd.getNombre());
            ps.setInt(2, pd.getStock());
            ps.setDouble(3, pd.getPrecio());
            ps.setString(4, pd.getProveedor());
            ps.setString(5, pd.getCodigo());
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
    
    public Producto buscarPorducto(String codigo) {
        Producto pd = new Producto();
        String query = "SELECT * FROM productos WHERE codigo=?";
        try {
            conn = cn.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            if(rs.next()){
                pd.setNombre(rs.getString("nombre"));
                pd.setPrecio(rs.getDouble("precio"));
                pd.setStock(rs.getInt("stock"));
            }
        } catch (SQLException e) {
            System.err.println(e.toString());
        }
        return pd;
    }
    
    public Configuracion buscarDatos() {
        Configuracion cnf = new Configuracion();
        String query = "SELECT * FROM configuracion";
        try {
            conn = cn.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            if(rs.next()){
                cnf.setId(rs.getInt("id"));
                cnf.setRfc(rs.getString("rfc"));
                cnf.setNombre(rs.getString("nombre"));
                cnf.setTelefono(rs.getString("telefono"));
                cnf.setDireccion(rs.getString("direccion"));
            }
        } catch (SQLException e) {
            System.err.println(e.toString());
        }
        return cnf;
    }
    
}
