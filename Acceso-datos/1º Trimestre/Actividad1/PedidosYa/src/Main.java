public class Main {
    public static void main(String[] args) {

        Operaciones operaciones = new Operaciones();
        operaciones.escribirCliente("src/Resources/clientes.dat");
        operaciones.exportarCliente("src/Resources/clientes.dat", "src/Resources/clientes.csv");
        operaciones.escribirPedido("src/Resources/pedidos.dat");
        operaciones.exportarPedido("src/Resources/pedidos.dat", "src/Resources/pedidos.csv");
        operaciones.leerObjeto("src/Resources/clientes.dat", true);
        operaciones.leerObjeto("src/Resources/pedidos.dat", false);
    }
}
