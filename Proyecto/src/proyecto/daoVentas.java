package proyecto;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
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
}
