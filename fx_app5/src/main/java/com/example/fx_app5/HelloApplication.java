package com.example.fx_app5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);

        HelloController helloController = fxmlLoader.getController();

        stage.setOnShown(windowEvent -> {
            System.out.println("Suscrito al repositorio");
            HelloRepository.getInstance().suscribe(helloController);
        });

        stage.setOnHidden(windowEvent -> {
            System.out.println("Desuscrito al repositorio");
            HelloRepository.getInstance().unsuscribe(helloController);
        });

        stage.show();

        for (int i = 0; i < 10; i++) {
            FXMLLoader fxmlLoader2 = new FXMLLoader(SegundoController.class.getResource("segundo-view.fxml"));
            Stage stage2 = new Stage();
            Scene scene2 = new Scene(fxmlLoader2.load(), 400, 500);
            stage2.setTitle(String.format("Ventana %d", i + 2));
            stage2.setScene(scene2);

            SegundoController segundoController = fxmlLoader2.getController();

            String message1 = String.format("Ventana %d: Suscrito al repositorio", i + 2);
            String message2 = String.format("Ventana %d: Desuscrito al repositorio", i + 2);

            stage2.setOnShowing(windowEvent -> {
                System.out.println(message1);
                HelloRepository.getInstance().suscribe(segundoController);
            });

            stage2.setOnHidden(windowEvent -> {
                System.out.println(message2);
                HelloRepository.getInstance().unsuscribe(segundoController);
            });

            stage2.show();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}