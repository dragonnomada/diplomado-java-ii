package com.example.fx_app5;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class HelloController implements IHelloRepositoryListener {

    private String nombre = "";
    private double precio = 0.0;

    @FXML
    private Label label1;
    @FXML
    private TextField textField1;
    @FXML
    private Label label2;
    @FXML
    private Slider slider1;

    @FXML
    protected void onNombreChanged() {
        //System.out.println("Nombre actualizado");
        nombre = textField1.getText();
        label1.setText(String.format("Nombre: %s", nombre));
    }

    @FXML
    protected void onPrecioChanged() {
        //System.out.println("Precio actualizado");
        precio = slider1.getValue();
        label2.setText(String.format("Precio: $%.2f", precio));
    }

    @FXML
    protected void onProductoGuardar() {
        HelloRepository.getInstance().setNombre(nombre);
        HelloRepository.getInstance().setPrecio(precio);
    }

    @Override
    public void onUpdateNombre(String nombre) {
        System.out.println("El nombre fue actualizado: " + nombre);
    }

    @Override
    public void onUpdatePrecio(double precio) {
        System.out.println("El precio fue actualizado: " + precio);
    }
}