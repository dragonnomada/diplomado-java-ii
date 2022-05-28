package view;

import controller.AgregarProductosController;
import model.ProductosDB;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Scanner;

public class AgregarProductoCLI implements IAgregarProductoView {

    AgregarProductosController controller = new AgregarProductosController();;
    ProductosDB model = new ProductosDB();

    Scanner scanner = new Scanner(System.in);

    public AgregarProductoCLI() throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        controller.setView(this);
        controller.setModel(model);
    }

    public void abrirMenu() {
        System.out.println("Selecciona una opción:");
        System.out.println("1. Agregar producto");
        System.out.println("2. Salir");

        int opcion = scanner.nextInt(); scanner.nextLine();

        switch (opcion) {
            case 1:
                controller.transactionAgregarProducto();
                break;
            case 2:
                scanner.close();
                System.out.println("Gracias");
                break;
            default:
                System.out.println("Opción no válida");
                reinciarVista();
                break;
        }
    }

    @Override
    public String getNombre() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        return nombre;
    }

    @Override
    public String getDescripcion() {
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();
        return descripcion;
    }

    @Override
    public double getPrecio() {
        System.out.print("Precio: ");
        double precio = scanner.nextDouble(); scanner.nextLine();
        return precio;
    }

    @Override
    public int getExistencias() {
        System.out.print("Existencias: ");
        int existencias = scanner.nextInt(); scanner.nextLine();
        return existencias;
    }

    @Override
    public void reinciarVista() {
        abrirMenu();
    }

    @Override
    public void mostrarAgregarProductoCorrecto() {
        System.out.println("Se agregó el producto correctamente");
        System.out.println("[Pulsa ENTER para continuar...]");
        scanner.nextLine();
    }

    @Override
    public void mostrarAgregarProductoError(String mensaje) {
        System.out.printf("Error al agregar el producto: %s\n", mensaje);
        System.out.println("[Pulsa ENTER para continuar...]");
        scanner.nextLine();
    }
}
