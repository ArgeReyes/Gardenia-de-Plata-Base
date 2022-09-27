package proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    Connection cx;
    
    String bd = "gardenia";
    String url = "jdbc:mariadb://localhost:3306/" + bd;
    String user = "root";
    String pass = "2010";

    public Conexion() throws SQLException {
        cx = DriverManager.getConnection(url, user, pass);
        cx.setAutoCommit(false);
    }
    
    public Connection conectar() throws SQLException {
        return cx;
    }
    
    public void desconectar(){
        try {
            cx.close();
            System.out.println("Se desconectó correctamente");
        } catch (SQLException ex) {
            System.out.println("No se pudo cerrrar conexión");
        }
    }
    
    public void commit() {
        try {
            cx.commit();
        } catch (SQLException ex) {
            try {
                cx.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void rollback() {
        try {
            cx.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) throws SQLException {
        Conexion c = new Conexion();
        c.conectar();
        c.desconectar();
    }
}
