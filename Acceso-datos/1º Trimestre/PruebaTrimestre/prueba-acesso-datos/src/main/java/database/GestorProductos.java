package database;

import ProductoDAO.*;
import Model.Producto;

import java.sql.SQLException;

public class GestorProductos {
    private ProductoDAOImp productoDAOImp;

    public GestorProductos() {
        productoDAOImp = new ProductoDAOImp();
    }

    public void insertarLibro(Producto producto) {
        try {
            productoDAOImp.insertar(producto);
        } catch (SQLException e) {
            System.out.println("Error en el SQL");
        }
    }
}
