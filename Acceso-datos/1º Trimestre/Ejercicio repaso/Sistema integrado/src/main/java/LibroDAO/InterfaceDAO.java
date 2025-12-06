package LibroDAO;

import model.Libro;

import java.sql.SQLException;
import java.util.ArrayList;

public interface InterfaceDAO<T> {
    boolean insertarDato(T data) throws SQLException;
    ArrayList<T> obtenerListaDatos();
    void actualizarDato(T datoNuevo);
    int borrarDatos(int id);

}
