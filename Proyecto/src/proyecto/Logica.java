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
        String []  nombresColumnas = {"ID","Nombre","Telefono"};
        String [] registros = new String[3];
        
        DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
        
        String sql = "SELECT * FROM vendedor";
        
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
                
                registros[2] = rs.getString("Telefono");
                
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
  
  public DefaultTableModel buscarPersonas(String buscar)
    {

        int contador = 1; // Dedicado para acomular en número de registros que hay en la tabla
        
        String []  nombresColumnas = {"  #  ","ID","Nombre","Telefono"," "};//Indica el nombre de las columnas en la tabla
        
        String [] registros = new String[4];
        
        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);
        
        String sql = "SELECT * FROM vendedor WHERE ID LIKE '%"+buscar+"%' OR nombre LIKE '%"+buscar+"%'";
        
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
                registros[0] = Integer.toString(contador);
                
                registros[1] = rs.getString("ID");
                
                registros[2] = rs.getString("Nombre");
               
                registros[3] = rs.getString("Telefono");                                
                
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
