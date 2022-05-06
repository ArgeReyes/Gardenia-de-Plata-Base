package proyecto;

/**
 *
 * @author brian
 */
public class EntidadVenta {
    private int ID;
    private float precio;
    private int descuentoID;
    private int vendedorID;
    private int usuarioID;
    private String fecha;

    public EntidadVenta(int ID, float precio, String fecha, int descuentoID, int vendedorID, int usuarioID) {
        this.ID = ID;
        this.precio = precio;
        this.fecha = fecha;
        this.descuentoID = descuentoID;
        this.vendedorID = vendedorID;
        this.usuarioID = usuarioID;
    }   

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the precio
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     * @return the descuentoID
     */
    public int getDescuentoID() {
        return descuentoID;
    }

    /**
     * @param descuentoID the descuentoID to set
     */
    public void setDescuentoID(int descuentoID) {
        this.descuentoID = descuentoID;
    }

    /**
     * @return the vendedorID
     */
    public int getVendedorID() {
        return vendedorID;
    }

    /**
     * @param vendedorID the vendedorID to set
     */
    public void setVendedorID(int vendedorID) {
        this.vendedorID = vendedorID;
    }

    /**
     * @return the usuarioID
     */
    public int getUsuarioID() {
        return usuarioID;
    }

    /**
     * @param usuarioID the usuarioID to set
     */
    public void setUsuarioID(int usuarioID) {
        this.usuarioID = usuarioID;
    }
    
    
}
