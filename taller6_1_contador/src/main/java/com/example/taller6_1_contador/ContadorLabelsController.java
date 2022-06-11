package com.example.taller6_1_contador;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Date;

public class ContadorLabelsController implements ContadorStoreActionListener {

    @FXML
    private Label labelValor;
    // <Label fx:id="labelValor" />

    @FXML
    private Label labelModificado;
    // <Label fx:id="labelModificado" />

    @Override
    public void onUpdateContador(int valor, Date fechaModificado) {
        //String text = String.format("CONTADOR: %d\nMODIFICADO: %s\n\n", valor, fechaModificado);
        //labelValor.setText(text);
        labelValor.setText(String.valueOf(valor));
        labelModificado.setText(fechaModificado.toString());
    }

}
