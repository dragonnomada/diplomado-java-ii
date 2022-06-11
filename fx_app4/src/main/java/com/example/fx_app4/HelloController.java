package com.example.fx_app4;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class HelloController {

    @FXML
    private CheckBox checkBox1;

    @FXML
    private Button buttonPresioname;

    @FXML
    protected void onHelloButtonClick() {
        System.out.println("Se pulsó el botón Hello!");
    }

    @FXML
    protected void onHelloMouseEnter(MouseEvent event) {
        System.out.println("Entró el mouse: " + event.getSceneX());
    }

    @FXML
    protected void onCheckboxAction() {
        System.out.println("Checkbox pulsado");
        if (checkBox1.isSelected()) {
            System.out.println("SELECCIONADO");
        } else {
            System.out.println("DESELECCIONADO");
        }
        buttonPresioname.setDisable(!checkBox1.isSelected());
    }

    @FXML
    protected void onPulsame() {
        System.out.println("Se pulsó el botón Pulsame");
    }

    @FXML
    protected void onPresioname() {
        System.out.println("Se pulsó el botón Presioname");
    }

}