import database.DBConnection;
import database.GestorLibros;
import model.Libro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Connection connection = DBConnection.getConnection();

        GestorLibros gestor = new GestorLibros();

        gestor.insertarLibro(new Libro("123114564879","Metodo","Carlos","Uno",2025,"Cualquiera",2354,25));

    }
}
