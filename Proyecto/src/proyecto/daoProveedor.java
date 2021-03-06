/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Marti Pérez
 */
public class daoProveedor {
    
    Conexion c;

    public daoProveedor() {
        c = new Conexion();
    }
    
    public boolean create(EntidadProveedor u){
        try {
            String sql = "INSERT INTO proveedor (ID, nombre, telefono, consigna) values (?,?,?,?)";
            PreparedStatement ps = (PreparedStatement) c.conectar().prepareStatement(sql);
            ps.setInt(1, u.getID());
            ps.setString(2, u.getNombre());
            ps.setInt(3, u.getTelefono());
            ps.setBoolean(4, u.isConsigna());
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
    
    public EntidadProveedor read(String nombre) {
        EntidadProveedor u = new EntidadProveedor();
        try {
            String sql = "SELECT * FROM  proveedor WHERE nombre=?";
            PreparedStatement ps = (PreparedStatement) c.conectar().prepareStatement(sql);
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
            c.desconectar();
        } catch (SQLException ex) {
            System.out.println("Fallo en el método read producto: " + ex);
        }
        return u;
    }
}
