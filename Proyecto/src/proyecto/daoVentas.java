package proyecto;

import java.sql.PreparedStatement;
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

    public boolean create(EntidadVenta u) {
        try {
            String sql = "INSERT INTO venta (ID, precio, fecha, Descuento_ID, vendedor_ID, Usuario_id) values (?,?,?,?,?,?)";
            PreparedStatement ps = (PreparedStatement) c.conectar().prepareStatement(sql);
            ps.setInt(1, u.getID());
            ps.setFloat(2, u.getPrecio());
            ps.setDate(3, null);
            ps.setInt(4, u.getDescuentoID());
            ps.setInt(5, u.getVendedorID());
            ps.setInt(6, u.getUsuarioID());
            ps.execute();
            ps.close();
            ps = null;
            c.desconectar();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al insertar la venta: " + ex);
            return false;
        }
    }
}
