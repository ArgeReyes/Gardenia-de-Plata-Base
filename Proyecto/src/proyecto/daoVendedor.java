package proyecto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class daoVendedor {

    Conexion c;

    public daoVendedor() throws SQLException {
        c = new Conexion();
    }

    public boolean create(EntidadVendedor v) {
        try {
            String sql = "INSERT INTO vendedor (ID, nombre, telefono) values (?,?,?)";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            ps.setInt(1, v.getID());
            ps.setString(2, v.getNombre());
            ps.setInt(3, v.getTelefono());
            ps.execute();
            ps.close();
            ps = null;
//            c.desconectar();
            return true;
        } catch (SQLException ex) {
            System.out.println("Ha ocurrido un error al crear el vendedor: " + ex);
            return false;
        }
    }

    public EntidadVendedor read(String nombre) {
        EntidadVendedor u = new EntidadVendedor();
        try {
            String sql = "SELECT * FROM  vendedor WHERE nombre=?";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                u.setID(rs.getInt("ID"));
                u.setNombre(rs.getString("nombre"));
                u.setTelefono(rs.getInt("Telefono"));

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
