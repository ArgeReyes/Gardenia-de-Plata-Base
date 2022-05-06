package proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    Connection cx;
    String bd = "gardenia";
    String url = "jdbc:mysql://localhost:3306/" + bd;
    String user = "root";

    String pass = "bbbbbbb7";

    
    public  Connection conectar() {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            cx = (Connection)DriverManager.getConnection(url, user, pass);
            System.out.println("Se conectó correctamente");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("No se conectó");
            System.out.println(ex);
        }
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
    
    public static void main(String[] args) {
        Conexion c = new Conexion();
        c.conectar();
        c.desconectar();
    }
}
