/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

/**
 *
 * @author Marti Pérez
 */
public class EntidadProveedor {
    int ID;
    String nombre;
    int telefono;
    boolean consigna;

    public EntidadProveedor(){
        System.out.println("Se creó un producto");
    }

    public EntidadProveedor(int ID, String nombre, int telefono, boolean consigna) {
        this.ID = ID;
        this.nombre = nombre;
        this.telefono = telefono;     
        this.consigna=consigna;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public boolean isConsigna() {
        return consigna;
    }

    public void setConsigna(boolean consigna) {
        this.consigna = consigna;
    }
    
    
}
