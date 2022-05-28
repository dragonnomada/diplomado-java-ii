package controller;

import model.IAgregarProductoModel;
import view.IAgregarProductoView;

public class AgregarProductosController {

    private IAgregarProductoModel model;
    private IAgregarProductoView view;

    public void setModel(IAgregarProductoModel model) {
        this.model = model;
    }

    public void setView(IAgregarProductoView view) {
        this.view = view;
    }

    public void transactionAgregarProducto() {
        // TODO: Obtener los datos del producto desde la vista
        // Producto producto = view.getProducto();
        String nombre = view.getNombre();
        String descripcion = view.getDescripcion();
        double precio = view.getPrecio();
        int existencias = view.getExistencias();
        if (nombre.isEmpty() || nombre.isBlank()) {
            view.mostrarAgregarProductoError("El nombre está vacío");
            return;
        }
        if (precio <= 0) {
            view.mostrarAgregarProductoError("El precio no es válido");
            return;
        }
        if (existencias < 0) {
            view.mostrarAgregarProductoError("Las existencias no son válidas");
            return;
        }
        // TODO: Mandarle los datos del producto al modelo
        if (model.agregarProducto(nombre, descripcion, precio, existencias)) {
            view.reinciarVista();
            view.mostrarAgregarProductoCorrecto();
        } else {
            view.mostrarAgregarProductoError("No se pudo agregar el producto");
        }
    }

}
