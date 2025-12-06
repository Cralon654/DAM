package LibroDAO;

import database.DBConnection;
import model.Libro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class LibroDAOImp implements InterfaceDAO<Libro>,LibroDao  {
    private Connection connection;

    private PreparedStatement preparedStatement;

    public LibroDAOImp() {
        connection = DBConnection.getConnection();
    }

    @Override
    public boolean insertarDato(Libro libro) throws SQLException {

            String query = String.format("INSERT INTO %s (%s,%s,%s,%s,%s,%s,%s,%s) VALUES (?,?,?,?,?,?,?,?)","libros","isbn","titulo","autor","editorial","ano_publicacion", "categoria","precio","stock");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,libro.getIsbn());
            preparedStatement.setString(2,libro.getTitulo());
            preparedStatement.setString(3,libro.getAutor());
            preparedStatement.setString(4,libro.getEditorial());
            preparedStatement.setInt(5,libro.getAno_publicacion());
            preparedStatement.setString(6,libro.getCategoria());
            preparedStatement.setDouble(7,libro.getPrecio());
            preparedStatement.setInt(8,libro.getStock());
            int row = preparedStatement.executeUpdate();

            if (row == 1) {
                System.out.println("Se ha insertado un usuario");
            } else if (row > 1) {
                System.out.println("Se han insertado los usuarios");
            }
            else {
                System.out.println("No se ha insertado ningun usuario");
            }
        return false;
    }

    @Override
    public ArrayList<Libro> obtenerListaDatos() {
        return null;
    }

    @Override
    public void actualizarDato(Libro datoNuevo) {

    }

    @Override
    public int borrarDatos(int id) {
        return 0;
    }

//
//
//    @Override

//        return false;
//    }    @Override



}
