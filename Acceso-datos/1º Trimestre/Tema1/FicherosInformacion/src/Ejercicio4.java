import java.io.*;

import javax.swing.JFileChooser;

public class Ejercicio4 {
    public static void main(String[] args) {
                // Crear un selector de archivos
        JFileChooser selector = new JFileChooser();

        // Mostrar el diálogo para abrir un archivo
        int resultado = selector.showOpenDialog(null);

        // Verificar si el usuario seleccionó un archivo
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = selector.getSelectedFile();
            System.out.println("Archivo seleccionado: " + archivoSeleccionado.getAbsolutePath());
        } else {
            System.out.println("No se seleccionó ningún archivo.");
        }
    }
}
