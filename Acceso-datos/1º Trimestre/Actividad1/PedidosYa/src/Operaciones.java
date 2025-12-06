import Model.Clientes;
import Model.Pedidos;

import java.io.*;

public class Operaciones {

    public void escribirCliente(String path) {

        File file = new File(path);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(new Clientes(1, "Carlos", "Carlos@gmail.com"));
            oos.writeObject(new Clientes(2, "Pedro", "Pedro@gmail.com"));
            oos.writeObject(new Clientes(3, "Juan", "Juan@gmail.com"));
        } catch (FileNotFoundException e) {
            System.out.println("El fichero no existe");
        } catch (IOException e) {
            //System.out.println(e);
        } finally {
            try {
                oos.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cerrado del fichero");
            }
        }

    }

    public void exportarCliente(String pathCLiente, String pathCsv) {
        File fileCliente = new File(pathCLiente);
        File fileCsv = new File(pathCsv);
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(fileCliente);
            ois = new ObjectInputStream(fis);
            Clientes cliente = null;

            while ((cliente = (Clientes) ois.readObject()) != null) {
                PrintWriter printWriter = null;
                try {
                    printWriter = new PrintWriter(new FileWriter(fileCsv, true));
                    printWriter.println("id,nombre,email");
                    printWriter.println(cliente);

                } catch (IOException e) {
                    //throw new RuntimeException(e);
                } finally {
                    printWriter.close();
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error, el fichero no se encuentra");
        } catch (IOException e) {
            //System.out.println(e);
        } catch (ClassNotFoundException | ClassCastException e) {
            System.out.println("Error en la clase de lectura");
        } finally {
            try {
                ois.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cerrado");
            }
        }


    }

    public void escribirPedido(String path) {

        File file = new File(path);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(new Pedidos(1, 1, 10, "Vaso"));
            oos.writeObject(new Pedidos(2, 3, 90, "Cuchara"));
            oos.writeObject(new Pedidos(3, 3, 10, "Plato"));
            oos.writeObject(new Pedidos(4, 2, 20, "Taza"));
            oos.writeObject(new Pedidos(5, 1, 30, "Mantel"));
        } catch (FileNotFoundException e) {
            System.out.println("El fichero no existe");
        } catch (IOException e) {
            //System.out.println(e);
        } finally {
            try {
                oos.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cerrado del fichero");
            }
        }

    }

    public void exportarPedido(String pathPedido, String pathCsv) {
        File fileCliente = new File(pathPedido);
        File fileCsv = new File(pathCsv);
        fileCliente.setExecutable(true);
        fileCsv.setExecutable(true);
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(fileCliente);
            ois = new ObjectInputStream(fis);
            Pedidos pedido = null;

            while ((pedido = (Pedidos) ois.readObject()) != null) {
                PrintWriter printWriter = null;
                try {
                    printWriter = new PrintWriter(new FileWriter(fileCsv, true));
                    printWriter.println("id,idcliente,cantidad,producto");
                    printWriter.println(pedido);

                } catch (IOException e) {
                    //throw new RuntimeException(e);
                } finally {
                    printWriter.close();
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error, el fichero no se encuentra");
        } catch (IOException e) {
//            System.out.println(e);
        } catch (ClassNotFoundException | ClassCastException e) {
            System.out.println("Error en la clase de lectura");
        } finally {
            try {
                ois.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cerrado");
            }
        }


    }

    public void leerObjeto(String path, boolean esCliente) {
        File file = new File(path);
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            if (esCliente) {
                Clientes cliente = null;
                System.out.println("Clientes");
                while ((cliente = (Clientes) ois.readObject()) != null) {
                    System.out.println(cliente.toString());

                }
            } else {
                Pedidos pedido = null;
                System.out.println("Pedidos");
                while ((pedido = (Pedidos) ois.readObject()) != null) {
                    System.out.println(pedido.toString());

                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error, el fichero no se encuentra");
        } catch (IOException e) {
            //System.out.println("No tienes permisos de lectura");
        } catch (ClassNotFoundException | ClassCastException e) {
            System.out.println("Error en la clase de lectura");
        } finally {
            try {
                ois.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cerrado");
            }
        }
    }


}
