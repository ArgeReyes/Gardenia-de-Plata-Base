package proyecto;

import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;

public class daoUsuario {
    Conexion c;
   
    public daoUsuario(){
        c = new Conexion();
    }
    
    public boolean create(EntidadUsuario u){
        try {
            String sql = "INSERT INTO usuario (ID, nombre, contraseña, tipo) values (?,?,?,?)";
            PreparedStatement ps = (PreparedStatement) c.conectar().prepareStatement(sql);
            ps.setInt(1, u.getID());
            ps.setString(2, u.getNombre());
            ps.setString(3, u.getContraseña());
            ps.setBoolean(4, u.isTipo());
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
