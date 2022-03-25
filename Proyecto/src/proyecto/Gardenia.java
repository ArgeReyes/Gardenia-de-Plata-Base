package proyecto;

public class Gardenia {

    public static void main(String[] args) {
        daoProducto dao;
        Producto p;
        dao = new daoProducto();
        p = new Producto(2, "RUBY", true, 35, "Sus mentiras", "2022-03-25", 12, 55);
        if (dao.create(p)) {
            System.out.println("Se creó correctamente");
        } else {
            System.out.println("error");
        }
    }
    
}
