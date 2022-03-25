package proyecto;

public class EntidadUsuario {
    int ID;
    String nombre;
    String contraseña;
    boolean tipo;

    public EntidadUsuario(){
        System.out.println("Usuario creado");
    }

    public EntidadUsuario(int ID, String nombre, String contraseña, boolean tipo) {
        this.ID = ID;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.tipo = tipo;
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

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }
    
    
}
