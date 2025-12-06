import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedHashMap; // Para mantener el orden de inserción o al ordenar
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Arrays;

public class Ejercicio2 {
    public static void main(String[] args) {


        String texto = "src/resources/articulo.txt";
        String[] palabras;
        int count = 0;
        try {
            BufferedReader lector = new BufferedReader(new FileReader(texto));
            try {
                String linea = lector.readLine();
                palabras = linea.split(" ");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {

        }

        // 21 Almacenar la frecuencia de cada palabra
        Map<String, Integer> frecuenciaPalabras = new HashMap<>();
        for (String palabra : palabras) {
            count++;
            if (!palabra.isEmpty()) { // Evitar contar cadenas vacías
                frecuenciaPalabras.put(palabra, frecuenciaPalabras.getOrDefault(palabra, 0) + 1);
            }
        }

        // 2. Ordenar el mapa y obtener las 5 palabras más frecuentes
        List<Map.Entry<String, Integer>> listaPalabrasOrdenada = new java.util.ArrayList<>(frecuenciaPalabras.entrySet());

        Collections.sort(listaPalabrasOrdenada, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue()); // Orden descendente por frecuencia
            }
        });

        // Mostrar las 5 palabras más frecuentes
        System.out.println("Número total de palabras: " + count);
        System.out.println("Las 5 palabras más frecuentes son:");
        for (
                int i = 0;
                i < 5 && i < listaPalabrasOrdenada.size(); i++) {
            System.out.println(listaPalabrasOrdenada.get(i).getKey() + ": " + listaPalabrasOrdenada.get(i).getValue());
        }

    }
}
