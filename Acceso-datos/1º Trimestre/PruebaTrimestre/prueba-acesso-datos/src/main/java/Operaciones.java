import Model.Producto;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class Operaciones {
    public void escribirProducto(String path) {

        File file = new File(path);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(new Producto(1, "zapato", 50, "ropa"));
            oos.writeObject(new Producto(2, "balon", 50, "deporte"));
            oos.writeObject(new Producto(3, "movil", 50, "telefonia"));
            oos.writeObject(new Producto(4, "martillo", 50, "herramienta"));
            oos.writeObject(new Producto(5, "camiseta", 50, "ropa"));

        } catch (FileNotFoundException e) {
            System.out.println("El fichero no existe");
        } catch (IOException e) {
            //System.out.println(e);
        } finally {
            try {

                oos.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cerrado del fichero");
            }
        }

    }

    public void generarXML(String path) throws ParserConfigurationException, TransformerException {
        File file = new File(path);
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        //Para escribir el xml
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();


        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);

            Producto producto = null;
            System.out.println("Clientes");


            Element root = document.createElement("productos");
            document.appendChild(root);

            while (true) {
                try {
                    producto = (Producto) ois.readObject();
                } catch (EOFException e) {
                    // Se llega al final del archivo, terminar el bucle
                    break;
                }

                System.out.println(producto.toString());

                Element productoXML = document.createElement("producto");
                root.appendChild(productoXML);

                // ID
                Element id = document.createElement("id");
                // Convertir el int a String
                id.setTextContent(String.valueOf(producto.getId()));

                // NOMBRE
                Element nombre = document.createElement("nombre");
                nombre.setTextContent(producto.getNombre());

                // PRECIO
                Element precio = document.createElement("precio");
                // Convertir el double/float/int a String (asumiendo que es un tipo numérico)
                precio.setTextContent(String.valueOf(producto.getPrecio()));

                // CATEGORIA
                Element categoria = document.createElement("categoria");
                categoria.setTextContent(producto.getCategoria());

                productoXML.appendChild(id);
                productoXML.appendChild(nombre);
                productoXML.appendChild(precio);
                productoXML.appendChild(categoria);

            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult((new File("productos.xml")));

            transformer.transform(source,result);



        } catch (FileNotFoundException e) {
            System.out.println("Error, el fichero no se encuentra");
        } catch (IOException e) {
            //System.out.println("No tienes permisos de lectura");
        } catch (ClassNotFoundException | ClassCastException e) {
            System.out.println("Error en la clase de lectura");
        } finally {
            try {
                ois.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cerrado");
            }
        }
    }
}
