package ProductoDAO;

import Model.Producto;

import java.sql.SQLException;

public interface ProductoDao {

    void insertar(Producto producto) throws SQLException;

    void procesarTransaccionPaso5(String categoriaAIncrementar, double porcentaje, int idAEliminar);

}
