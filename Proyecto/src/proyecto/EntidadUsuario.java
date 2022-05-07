package proyecto;

public class EntidadUsuario {
    int ID;
    String nombre;
    String contraseña;

    public EntidadUsuario(){
        System.out.println("Usuario creado");
    }

    public EntidadUsuario(int ID, String nombre, String contraseña) {
        this.ID = ID;
        this.nombre = nombre;
        this.contraseña = contraseña;
    }
    
    public EntidadUsuario(int ID, String nombre) {
        this.ID = ID;
        this.nombre = nombre;
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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
