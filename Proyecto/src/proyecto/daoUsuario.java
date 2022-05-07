package proyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class daoUsuario {

    Conexion c;

    public daoUsuario() {
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

    public EntidadUsuario read(String nombre) {
        EntidadUsuario u = new EntidadUsuario();
        try {
            String sql = "SELECT * FROM  usuario WHERE nombre=?";
            PreparedStatement ps = (PreparedStatement) c.conectar().prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                u.setID(rs.getInt("ID"));
                u.setNombre(rs.getString("nombre"));
                u.setContraseña(rs.getString("contraseña"));
            }
            ps.close();
            ps = null;
            c.desconectar();
        } catch (SQLException ex) {
            System.out.println("Fallo en el método read producto: " + ex);
        }
        return u;
    }
    
    public boolean delete(String nombre) {
        try {
            String sql = "DELETE FROM usuario WHERE nombre = ?";
            com.mysql.jdbc.PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) c.conectar().prepareStatement(sql);
            ps.setString(1, nombre);
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

     public DefaultTableModel buscarUsuario(String buscar) {

        int contador = 1; // Dedicado para acomular en número de registros que hay en la tabla

        String[] nombresColumnas = {" # ", "nombre", "contraseña"};//Indica el nombre de las columnas en la tabla

        String[] registros = new String[3];

        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);

        String sql = "SELECT * FROM usuario WHERE ID LIKE '%" + buscar + "%' OR nombre LIKE '%" + buscar + "%'";

        Connection cn = null;

        PreparedStatement pst = null;

        ResultSet rs = null;

        try {
            cn = Conexion1.getConnection();

            pst = cn.prepareStatement(sql);

            rs = pst.executeQuery();

            while (rs.next()) {
                registros[0] = rs.getString("ID");

                registros[1] = rs.getString("Nombre");


                modelo.addRow(registros);

                contador++;

            }
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error al conectar. " + e.getMessage());

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (pst != null) {
                    pst.close();
                }

                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        return modelo;
    }
    
    public ArrayList<EntidadUsuario> read() {
        ArrayList<EntidadUsuario> lista = new ArrayList<EntidadUsuario>();
        try {
            String sql = "SELECT * FROM  usuario";
            PreparedStatement ps = (PreparedStatement) c.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                EntidadUsuario p = new EntidadUsuario();
                p.setID(rs.getInt("ID"));
                p.setNombre(rs.getString("nombre"));
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
