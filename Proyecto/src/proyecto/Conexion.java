package proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    Connection cx;
    String bd = "gardenia";
    String url = "jdbc:mariadb://localhost:3306/" + bd;
    String user = "root";
    String pass = "bbbbbbb7";

    
    public  Connection conectar() throws SQLException {
        cx = DriverManager.getConnection(url, user, pass);
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
    
    public static void main(String[] args) throws SQLException {
        Conexion c = new Conexion();
        c.conectar();
        c.desconectar();
    }
}
