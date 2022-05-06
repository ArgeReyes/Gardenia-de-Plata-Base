/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

/**
 *
 * @author ARGENTINA REYES
 */
public class validaciones {
    
    public static boolean ValidarNumero (String datos){
    
        return datos.matches("[0-9-.]*");
    }
    
    private static boolean isNumeric(String cadena){
	try {
		Float.parseFloat(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
}
    
}
