import Model.Producto;
import ProductoDAO.ProductoDAOImp;
import ProductoDAO.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;

public class Main {
    static void main(String[] args) throws ParserConfigurationException, TransformerException {
        Operaciones operaciones = new Operaciones();
        ProductoDAOImp dao = new ProductoDAOImp();
        operaciones.escribirProducto("src/main/resources/productos.dat");
        operaciones.generarXML("src/main/resources/productos.dat");

        try {
            File xmlFile = new File("productos.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("producto");

            System.out.println("Cargando productos del XML a la BD...");

            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i); // Aquí SI usas 'i' para obtener el producto actual

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    // Crear objeto producto
                    // CORRECCIÓN: Usa item(0) porque dentro de ESTE producto, el id es el primer (y único) elemento.
                    int id = Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent());

                    String nombre = element.getElementsByTagName("nombre").item(0).getTextContent();

                    double precio = Double.parseDouble(element.getElementsByTagName("precio").item(0).getTextContent());

                    String categoria = element.getElementsByTagName("categoria").item(0).getTextContent();

                    Producto producto = new Producto(id, nombre, precio, categoria);

                    // Llamar al DAO para insertar
                    dao.insertar(producto);
                }
            }
            System.out.println("Carga inicial completada.");

        } catch (Exception e) {
            e.printStackTrace();
        }

        dao.procesarTransaccionPaso5("periféricos", 10.0, 2);


    }
}
