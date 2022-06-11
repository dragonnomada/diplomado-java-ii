package com.example.javafxdemo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SecondViewController implements HelloRepositoryListener {

    @FXML
    private TextField textField1;

    @FXML
    protected void onAceptarClick(ActionEvent event) {
        HelloRepository.getInstance().setTitle(textField1.getText());

        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }

    @Override
    public void onUpdate() {
        System.out.println("SecondViewController: El repositorio fue actualizado | " + this.hashCode());
    }
}
