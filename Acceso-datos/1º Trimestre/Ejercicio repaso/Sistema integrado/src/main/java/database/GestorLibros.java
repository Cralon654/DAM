package database;

import LibroDAO.*;
import model.Libro;

import java.sql.SQLException;

public class GestorLibros {
    private LibroDAOImp libroDAOImp;

    public GestorLibros() {
        libroDAOImp = new LibroDAOImp();
    }

    public void insertarLibro(Libro libro) {
        try {
            libroDAOImp.insertarDato(libro);
        } catch (SQLException e) {
            System.out.println("Error en el SQL");
        }
    }
}
