package proyecto;

public class EntidadProducto {

    int ID;
    String nombre;
    boolean consignacion;
    int existencia;
    String material;
    String fechaIngreso;
    float costo;
    float peso;
    
    public EntidadProducto(){
        System.out.println("Se creó un producto");
    }

    public EntidadProducto(int ID, String nombre, boolean consignacion, int existencia, String material, String fechaIngreso, float costo, float peso) {
        this.ID = ID;
        this.nombre = nombre;
        this.consignacion = consignacion;
        this.existencia = existencia;
        this.material = material;
        this.fechaIngreso = fechaIngreso;
        this.costo = costo;
        this.peso = peso;
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

    public boolean isConsignacion() {
        return consignacion;
    }

    public void setConsignacion(boolean consignacion) {
        this.consignacion = consignacion;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "EntidadProducto{" + "ID=" + ID + ", nombre=" + nombre + ", consignacion=" + consignacion + ", existencia=" + existencia + ", material=" + material + ", fechaIngreso=" + fechaIngreso + ", costo=" + costo + ", peso=" + peso + '}';
    }

}
