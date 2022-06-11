package com.example.javafxdemo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController implements HelloRepositoryListener {
    @FXML
    private Label welcomeText;

    @FXML
    private CheckBox checkBoxAceptar;

    @FXML
    protected void initialize() {
        System.out.println("HelloController initialized");
        HelloRepository.getInstance().subscribe(this);
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onSecondViewOpen() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("second-view.fxml"));

            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();
            stage.setTitle("Second View");
            stage.setScene(scene);

            SecondViewController secondViewController = fxmlLoader.getController();

            stage.setOnHidden(windowEvent -> {
                System.out.println("Cerrando secondViewController");
                HelloRepository.getInstance().unsubscribe(secondViewController);
            });

            stage.setOnShown(windowEvent -> {
                System.out.println("Mostrando secondViewController");
                HelloRepository.getInstance().subscribe(secondViewController);
            });

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onAceptarChange() {
        if (checkBoxAceptar.isSelected()) {
            System.out.println("Seleccionado");
        } else {
            System.out.println("Desmarcado");
        }
    }

    @Override
    public void onUpdate() {
        System.out.println("HelloController update HelloRepository | " + hashCode());
        welcomeText.setText(HelloRepository.getInstance().getTitle());
    }
}