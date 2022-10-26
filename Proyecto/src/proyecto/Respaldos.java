package proyecto;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;


public class Respaldos {
     
     public void backup1(){
         String dateTime = DateTimeFormatter.ofPattern("MMM dd yyyy, hh mm ss a").format(LocalDateTime.now());
         
         
        try {
            Process p= Runtime.getRuntime().exec("mysqldump -u loot -pbbbbbbb7 gardenia -R");
            InputStream is = p.getInputStream();
            String ruta ="C:/Users/brian/Documents/NetBeansProjects/Gardenia-de-Plata-Base/RespaldoIncremental/"+dateTime.toString()+"gardenia.sql";
            FileOutputStream fos = new FileOutputStream(ruta);
            byte[] buffer = new byte[1000];
            int leido = is.read(buffer);
            while(leido>0){
            fos.write(buffer, 0, leido);
            leido = is.read(buffer);
            }
            
            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(Respaldos.class.getName()).log(Level.SEVERE, null, ex);
        }
             
         
    }
     
      public void backup2(){
         String dateTime = DateTimeFormatter.ofPattern("MMM dd yyyy").format(LocalDateTime.now());
         
         
        try {
            Process p= Runtime.getRuntime().exec("mysqldump -u loot -pbbbbbbb7 gardenia");
            InputStream is = p.getInputStream();
            String ruta ="C:/Users/brian/Documents/NetBeansProjects/Gardenia-de-Plata-Base/RespaldoCompleto/"+dateTime.toString()+"Rgardenia.sql";
            FileOutputStream fos = new FileOutputStream(ruta);
            byte[] buffer = new byte[1000];
            int leido = is.read(buffer);
            while(leido>0){
            fos.write(buffer, 0, leido);
            leido = is.read(buffer);
            }
            
            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(Respaldos.class.getName()).log(Level.SEVERE, null, ex);
        }
             
         
    }
      
     public void Respaldo(String path){
         
     try {
            Process p= Runtime.getRuntime().exec("mysql -u loot -pbbbbbbb7 gardenia");
            OutputStream os= p.getOutputStream();
            System.out.println(path);
            FileInputStream fis = new FileInputStream(path);
            byte[] buffer = new byte[1000];
            int leido = fis.read(buffer);
            while(leido>0){
            os.write(buffer, 0, leido);
            leido = fis.read(buffer);
            }
            os.flush();
            os.close();
            fis.close();
        } catch (IOException ex) {
            Logger.getLogger(Respaldos.class.getName()).log(Level.SEVERE, null, ex);
        }
     }

    
}
