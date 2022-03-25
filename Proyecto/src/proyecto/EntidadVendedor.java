package proyecto;

public class EntidadVendedor {
    int ID;
    String nombre;
    int telefono;

    public EntidadVendedor(){
        System.out.println("Se creó un producto");
    }

    public EntidadVendedor(int ID, String nombre, int telefono) {
        this.ID = ID;
        this.nombre = nombre;
        this.telefono = telefono;     
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
    
}
