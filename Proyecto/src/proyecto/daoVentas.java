package proyecto;

import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author brian
 */
public class daoVentas {
    Conexion c;

    public daoVentas() {
        c = new Conexion();
    }
    
        public boolean create(EntidadUsuario u) {
        try {
            String sql = "INSERT INTO usuario (ID, nombre, contraseña) values (?,?,?)";
            PreparedStatement ps = (PreparedStatement) c.conectar().prepareStatement(sql);
            ps.setInt(1, u.getID());
            ps.setString(2, u.getNombre());
            ps.setString(3, u.getContraseña());
            ps.execute();
            ps.close();
            ps = null;
            c.desconectar();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al crear el usuario: " + ex);
            return false;
        }
    }
}
