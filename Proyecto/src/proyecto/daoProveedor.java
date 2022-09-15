package proyecto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class daoProveedor {

    Conexion c;

    public daoProveedor() {
        try {
            c = new Conexion();
        } catch (SQLException ex) {
            Logger.getLogger(daoProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean create(EntidadProveedor u) {
        try {
            String sql = "INSERT INTO proveedor (ID, nombre, telefono, consigna) values (?,?,?,?)";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            ps.setInt(1, u.getID());
            ps.setString(2, u.getNombre());
            ps.setInt(3, u.getTelefono());
            ps.setBoolean(4, u.isConsigna());
            ps.execute();
            ps.close();
            ps = null;
//            c.desconectar();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al crear el usuario: " + ex);
            return false;
        }
    }

    public EntidadProveedor read(String nombre) {
        EntidadProveedor u = new EntidadProveedor();
        try {
            String sql = "SELECT * FROM  proveedor WHERE nombre=?";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                u.setID(rs.getInt("ID"));
                u.setNombre(rs.getString("nombre"));
                u.setTelefono(rs.getInt("telefono"));
                u.setConsigna(rs.getBoolean("consigna"));
            }
            ps.close();
            ps = null;
//            c.desconectar();
        } catch (SQLException ex) {
            System.out.println("Fallo en el método read producto: " + ex);
        }
        return u;
    }

    public void confirmar() {
        c.commit();
        c.desconectar();
    }

    public void cancelar() {
        c.rollback();
        c.desconectar();
    }
}
