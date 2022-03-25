/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * 
 * @author Marti Pérez
 */
public class Registro {
  public boolean Resgistro(int ID, String Nombre, int Telefono){
        String sql="INSERT INTO vendedor(ID, Nombre, Telefono) VALUES (?,?,?)";
        Connection conectar;
        PreparedStatement pst;
        
        try {
            conectar=(Connection) Conexion1.getConnection();
              pst = conectar.prepareStatement(sql);
            
            pst.setInt(1,ID);
            
            pst.setString(2, Nombre);
            
            pst.setInt(3, Telefono);
            
            
            
            int i = pst.executeUpdate();
            
            if (i != 0)
            {
                JOptionPane.showMessageDialog(null,"Los datos se han guardado satisfactoriamente");
                
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Error en la transaccion");
                
                return false;
            }
            
        }
        catch (SQLException e) {
      JOptionPane.showMessageDialog(null, e.getMessage());
            
            return false;
        }
        
    }
}
