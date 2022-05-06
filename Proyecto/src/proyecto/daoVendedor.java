package proyecto;

import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;

public class daoVendedor {
    Conexion c;
    
    public daoVendedor(){
        c = new Conexion();
    }
    
    public boolean create(EntidadVendedor v){
        try {
            String sql = "INSERT INTO vendedor (ID, nombre, telefono) values (?,?,?)";
            PreparedStatement ps = (PreparedStatement) c.conectar().prepareStatement(sql);
            ps.setInt(1, v.getID());
            ps.setString(2, v.getNombre());
            ps.setInt(3, v.getTelefono());
            ps.execute();
            ps.close();
            ps = null;
            c.desconectar();
            return true;
        } catch (SQLException ex) {
            System.out.println("Ha ocurrido un error al crear el vendedor: " + ex);
            return false;
        }
    }
}
