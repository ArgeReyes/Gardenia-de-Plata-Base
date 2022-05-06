/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * 
 * @author Marti Pérez
 */
public class Logica {
 public DefaultTableModel mostrarClientes()
    {
        String []  nombresColumnas = {"ID","Nombre","consignacion","existencia","material","fechaIngreso","costo","peso"};
        String [] registros = new String[8];
        
        DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
        
        String sql = "SELECT * FROM producto";
        
        Connection con = null;
        
        PreparedStatement pst = null;
        
        ResultSet rs = null;
        
        try
        {
            con = Conexion1.getConnection();
            
            pst = con.prepareStatement(sql);                      
            
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                registros[0] = rs.getString("ID");
                
                registros[1] = rs.getString("Nombre");
                
                registros[2] = rs.getString("consignacion");
                registros[3] = rs.getString("existencia");
                registros[4] = rs.getString("material");
                registros[5] = rs.getString("fechaIngreso");
                registros[6] = rs.getString("costo");
                registros[7] = rs.getString("peso");
                
                modelo.addRow(registros);
                
            }
            
           
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error al conectar");
            
        }
        finally
        {
            try
            {
                if (rs != null) rs.close();
                
                if (pst != null) pst.close();
                
                if (con != null) con.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
         return modelo;
    }  

public DefaultTableModel BuscarUser(String buscar, String contra){
     int contador = 1; // Dedicado para acomular en número de registros que hay en la tabla

        String []  nombresColumnas = {"  #  ","nombre","contraseña"};//Indica el nombre de las columnas en la tabla

        String [] registros = new String[4];

        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);

        String sql = "SELECT * FROM Usuario WHERE nombre LIKE '%"+buscar+"%' AND contraseña LIKE '%"+contra+"%'";

        Connection cn = null;

        PreparedStatement pst = null;

        ResultSet rs = null;                          

        try
        {
            cn = Conexion1.getConnection();

            pst = cn.prepareStatement(sql);                       

            rs = pst.executeQuery();

            while(rs.next())
            {
                registros[0] = rs.getString("ID");

                registros[1] = rs.getString("nombre");

                registros[2] = rs.getString("contraseña");                     

                modelo.addRow(registros);

                contador++;

            }                     
        }
        catch(SQLException e)
        {

            JOptionPane.showMessageDialog(null,"Error al conectar. "+e.getMessage());

        }
        finally
        {
            try
            {
                if (rs != null) rs.close();

                if (pst != null) pst.close();

                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
         return modelo;
    }  
}
