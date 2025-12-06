package Model;
import java.io.Serializable;

public class Pedidos implements Serializable{
    private static Long serialVersionUID = 4567L;
    private int id, clienteId, cantidad;
    private String producto;

    public Pedidos() {
        id = 0;
        clienteId = 0;
        cantidad = 0;
        producto = "vaso";

    }

    public Pedidos(int id, int clienteId, int cantidad, String producto) {
        this.id = id;
        this.clienteId = clienteId;
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(Long serialVersionUID) {
        Pedidos.serialVersionUID = serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return String.format("%d,%d,%d,%s",id,clienteId,cantidad,producto);
    }
}
