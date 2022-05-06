package proyecto;

public class Gardenia {

    public static void main(String[] args) {
        /*
        daoProducto dao;
        Producto p;
        dao = new daoProducto();
        p = new Producto(2, "RUBY", true, 35, "Sus mentiras", "2022-03-25", 12, 55);
        if (dao.create(p)) {
            System.out.println("Se creó correctamente");
        } else {
            System.out.println("error");
        }
        ------------------------------
        daoUsuario dao;
        EntidadUsuario u;
        dao = new daoUsuario();
        u = new EntidadUsuario(5, "marti", "pk", false);
        if (!dao.create(u)) {
            System.out.println("error");
        }
        */
        daoProducto dao;
        EntidadProducto p;
        dao = new daoProducto();
        if (dao.delete(1)) {
            System.out.println("Se eliminó correctamente");
        } else {
            System.out.println("error");
        }
    }

}
