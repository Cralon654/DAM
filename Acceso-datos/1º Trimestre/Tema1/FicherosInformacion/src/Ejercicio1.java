import java.io.File;
import java.util.Date;

public class Ejercicio1 {
    public static void main(String[] args) {
            File archivo = new File("/Users/carloscanocastrillon/Desktop/Escritorio - MacBook Pro de Carlos/DAM");
            //Ejercio 1
            File [] ficheros = archivo.listFiles();
            Date diaMs = new Date();

            for (File f: ficheros) {
                if (f.isFile()) {
                    System.out.println("[ARCHIVO] " +f.getName() + " " + f.length() + " bytes " + " - Última modificación " + f.lastModified());
                    
                }

                if (f.isDirectory()) {
                    System.out.println("[DIRECTORIO] " +f.getName() + " - Última modificación " + f.lastModified());

                }
            }

    }
}
