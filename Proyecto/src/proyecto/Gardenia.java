package proyecto;

public class Gardenia {

    public static void main(String[] args) {
        daoProducto dao;
        Producto p;
        dao = new daoProducto();
        p = new Producto(1, "JOYA", true, 35, "Obsidiana", "2022-03-24", 12, 25);
        if (dao.create(p)) {
            System.out.println("Se creó correctamente");
        } else {
            System.out.println("error");
        }
    }
    
}
