package ProductoDAO;

import Model.Producto;
import database.DBConnection;
import Model.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductoDAOImp implements ProductoDao {
    private Connection connection;

    private PreparedStatement preparedStatement;

    public ProductoDAOImp() {
        connection = DBConnection.getConnection();
    }

    @Override
    public void insertar(Producto producto) throws SQLException {
        String sql = "INSERT INTO productos (id, nombre, precio, categoria) VALUES (?, ?, ?, ?)";

        // Usamos try-with-resources para cerrar la conexión y el statement automáticamente
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, producto.getId());
            pstmt.setString(2, producto.getNombre());
            pstmt.setDouble(3, producto.getPrecio());
            pstmt.setString(4, producto.getCategoria());

            pstmt.executeUpdate();
        }
    }


    @Override
    public void procesarTransaccionPaso5(String categoriaAIncrementar, double porcentaje, int idAEliminar) {

        PreparedStatement pstmtUpdate = null;
        PreparedStatement pstmtDelete = null;

        try {
            
            connection.setAutoCommit(false);
            System.out.println("--- Iniciando Transacción ---");

            String sqlUpdate = "UPDATE productos SET precio = precio * ? WHERE categoria = ?";
            pstmtUpdate = connection.prepareStatement(sqlUpdate);

            double multiplicador = 1 + (porcentaje / 100);
            pstmtUpdate.setDouble(1, multiplicador);
            pstmtUpdate.setString(2, categoriaAIncrementar);

            int filasUpdate = pstmtUpdate.executeUpdate();
            System.out.println("Actualización preparada: " + filasUpdate + " productos modificados.");

            String sqlDelete = "DELETE FROM productos WHERE id = ?";
            pstmtDelete = connection.prepareStatement(sqlDelete);
            pstmtDelete.setInt(1, idAEliminar);

            int filasDelete = pstmtDelete.executeUpdate();
            System.out.println("Eliminación preparada: " + filasDelete + " productos eliminados.");
            connection.commit();
            System.out.println("--- Transacción EXITOSA (Commit realizado) ---");

        } catch (SQLException e) {

            System.err.println("Error en la transacción: " + e.getMessage());
            if (connection != null) {
                try {
                    System.err.println("Ejecutando ROLLBACK...");
                    connection.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } finally {
            // Cerrar recursos manualmente
            try {
                if (pstmtUpdate != null) pstmtUpdate.close();
                if (pstmtDelete != null) pstmtDelete.close();
                if (connection != null) {
                    connection.setAutoCommit(true); // Restaurar estado original
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
