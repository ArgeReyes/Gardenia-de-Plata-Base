/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;
import javax.crypto.*;
import java.security.*;

/**
 *
 * @author ARGENTINA REYES
 */
public class cifrar {
    
    
        public String cifrado (String cadena)
    {
        try{
            java.security.MessageDigest cf = java.security.MessageDigest.getInstance("MD5");
            byte[] array = cf.digest(cadena.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i=0; i<array.length; i++){
            
                sb.append(Integer.toHexString((array[i] & 0xFF) |0X100).substring(1,3));
            }
                
        return sb.toString();
    }catch (java.security.NoSuchAlgorithmException e){
        
    
    }
    

