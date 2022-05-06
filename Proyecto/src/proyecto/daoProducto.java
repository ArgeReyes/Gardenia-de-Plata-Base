|package proyecto;

import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;

public class daoProducto {
    Conexion c;
    
    public daoProducto(){
        c = new Conexion();
    }
    
    public boolean create(Producto p){
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
            System.out.println("No se insertó registro");
            return false;
        }
    }
}
