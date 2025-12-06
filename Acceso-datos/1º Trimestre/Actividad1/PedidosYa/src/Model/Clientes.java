package Model;
import java.io.Serializable;

public class Clientes implements Serializable {

    private static Long serialVersionUID = 4567L;
    private int id;
    private String nombre, email;

    public Clientes() {
        id = 0;
        nombre = "Carlos";
        email = "prueba@gmail.com";
    }

    public Clientes(int id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }
    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }
    public static void setSerialVersionUID(Long serialVersionUID) {
        Clientes.serialVersionUID = serialVersionUID;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("%d,%s,%s",id,nombre,email);
    }
}
