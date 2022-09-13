package proyecto;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

public class daoProducto {

    Conexion c;

    public daoProducto() {
        c = new Conexion();
    }

    public boolean create(EntidadProducto p) {
        try {
            String sql = "INSERT INTO producto (ID, nombre, consignacion, existencia, material, fechaIngreso, costo, peso) values (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = (PreparedStatement) c.conectar().prepareStatement(sql);
            ps.setInt(1, p.getID());
            ps.setString(2, p.getNombre());
            ps.setBoolean(3, p.isConsignacion());
            ps.setInt(4, p.getExistencia());
            ps.setString(5, p.getMaterial());
            ps.setString(6, p.getFechaIngreso());
            ps.setFloat(7, p.getCosto());
            ps.setFloat(8, p.getPeso());
            ps.execute();
            ps.close();
            ps = null;
            c.desconectar();
            return true;
        } catch (SQLException ex) {
            System.out.println("No se insertó registro: " + ex);
            return false;
        }
    }

    public ArrayList<EntidadProducto> read() {
        ArrayList<EntidadProducto> lista = new ArrayList<EntidadProducto>();
        try {
            String sql = "SELECT * FROM  producto";
            PreparedStatement ps = (PreparedStatement) c.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                EntidadProducto p = new EntidadProducto();
                p.setID(rs.getInt("ID"));
                p.setNombre(rs.getString("nombre"));
                p.setConsignacion(rs.getBoolean("consignacion"));
                p.setExistencia(rs.getInt("existencia"));
                p.setMaterial(rs.getString("material"));
                p.setFechaIngreso(rs.getString("fechaIngreso"));
                p.setCosto(rs.getFloat("costo"));
                p.setPeso(rs.getFloat("peso"));
                lista.add(p);
            }
            ps.close();
            ps = null;
            c.desconectar();
        } catch (SQLException ex) {
            System.out.println("Fallo en el método read: " + ex);
        }
        return lista;
    }

    public boolean delete(int id) {
        try {
            String sql = "DELETE FROM producto WHERE ID = ?";
            PreparedStatement ps = (PreparedStatement) c.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            ps.close();
            ps = null;
            c.desconectar();
            return true;
        } catch (SQLException ex) {
            System.out.println("Fallo al elimiar: " + ex);
            return false;
        }
    }

    public boolean update(EntidadProducto p) {
        try {
            String sql = "UPDATE producto SET nombre=?, consignacion=?, existencia=?, material=?, fechaIngreso=?, costo=?, peso=? WHERE ID=?";
            PreparedStatement ps = (PreparedStatement) c.conectar().prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setBoolean(2, p.isConsignacion());
            ps.setInt(3, p.getExistencia());
            ps.setString(4, p.getMaterial());
            ps.setString(5, p.getFechaIngreso());
            ps.setFloat(6, p.getCosto());
            ps.setFloat(7, p.getPeso());
            ps.setInt(8, p.getID());

            ps.executeUpdate();
            ps.close();
            ps = null;
            c.desconectar();
            return true;
        } catch (SQLException ex) {
            System.out.println("No se actualizó el registro: " + ex);
            return false;
        }
    }

    public EntidadProducto read(int id) {
        EntidadProducto p = new EntidadProducto();
        try {
            String sql = "SELECT * FROM  producto WHERE ID=?";
            PreparedStatement ps = (PreparedStatement) c.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                p.setID(rs.getInt("ID"));
                p.setNombre(rs.getString("nombre"));
                p.setConsignacion(rs.getBoolean("consignacion"));
                p.setExistencia(rs.getInt("existencia"));
                p.setMaterial(rs.getString("material"));
                p.setFechaIngreso(rs.getString("fechaIngreso"));
                p.setCosto(rs.getFloat("costo"));
                p.setPeso(rs.getFloat("peso"));
            }
            ps.close();
            ps = null;
            c.desconectar();
        } catch (SQLException ex) {
            System.out.println("Fallo en el método read producto: " + ex);
        }
        return p;
    }
}
