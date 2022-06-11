package com.example.taller6_1_contador;

import javafx.fxml.FXML;

public class ContadorBotonesController {

    @FXML
    protected void onIncrementar() {
        System.out.println("Incrementando...");
        ContadorStore.getInstance().incrementar();
        System.out.println(ContadorStore.getInstance().getValor());
        System.out.println(ContadorStore.getInstance().getFechaModificado());
    }
    // <Button onAction="#onIncrementar" />

    @FXML
    protected void onDecrementar() {
        System.out.println("Decrementando...");
        ContadorStore.getInstance().decrementar();
        System.out.println(ContadorStore.getInstance().getValor());
        System.out.println(ContadorStore.getInstance().getFechaModificado());
    }
    // <Button onAction="#onDecrementar" />

    @FXML
    protected void onReiniciar() {
        System.out.println("Reiniciando...");
        ContadorStore.getInstance().reiniciar();
        System.out.println(ContadorStore.getInstance().getValor());
        System.out.println(ContadorStore.getInstance().getFechaModificado());
    }
    // <Button onAction="#onReiniciar" />

}
