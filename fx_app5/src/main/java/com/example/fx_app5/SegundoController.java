package com.example.fx_app5;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SegundoController implements IHelloRepositoryListener {

    @FXML
    private Label labelNombre;
    @FXML
    private Label labelPrecio;

    @Override
    public void onUpdateNombre(String nombre) {
        System.out.println("Ventana 2: Cambió el nombre: " + nombre);
        labelNombre.setText(String.format("Nombre: %s", nombre));
    }

    @Override
    public void onUpdatePrecio(double precio) {
        System.out.println("Ventana 2: Cambió el precio: " + precio);
        labelPrecio.setText(String.format("Precio: $%.2f", precio));
    }
}
