/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * 
 * @author Marti Pérez
 */
public class Conexion1 {

        public static Connection getConnection()
    {
        Connection con = null;
        
        
        String url = "jdbc:mysql://localhost:3306/gardenia";
        String user = "root";// el usuario que ustedes tienen
        String pass = "martipj12";// la clave que uestedes tienen
        
        try
        {
            Class.forName("org.gjt.mm.mysql.Driver");
            
            con =  DriverManager.getConnection(url, user, pass);
            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        
        return con;
    }
}
