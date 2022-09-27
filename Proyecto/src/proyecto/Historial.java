package proyecto;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Historial {

    public Historial() {
    }

    public Historial(String nombreArchivo) {
        File archivo = new File("nombreArchivo");
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
            System.out.println("Se ha creado el archivo");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public void guardarHistorial(String nombreArchivo, String transacciones) {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.println(transacciones);
            salida.close();
            System.out.println("Se ha escrito el archivo");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public void anexarHistorial(String nombreArchivo, String transacciones) {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
            salida.print(transacciones);
            salida.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public String leerHistorial(String nombreArchivo) {
        String historial = "";
        var archivo = new File(nombreArchivo);
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            var lectura = entrada.readLine();
            while (lectura != null) {
                historial += lectura + "\n";
                lectura = entrada.readLine();
            }
            entrada.close();
            return historial;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        return historial;
    }
}
