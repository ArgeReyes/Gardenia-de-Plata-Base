/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion1 {

        public static Connection getConnection() throws SQLException
    {
        Connection con = null;
        
        String url = "jdbc:mariadb://localhost:3306/gardenia";
        String user = "root";// el usuario que ustedes tienen
        String pass = "bbbbbbb7";// la clave que uestedes tienen

        con =  DriverManager.getConnection(url, user, pass);
        con.setAutoCommit(false);
        
        return con;
    }
}
