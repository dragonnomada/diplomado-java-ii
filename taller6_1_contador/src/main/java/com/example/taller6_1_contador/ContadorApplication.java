package com.example.taller6_1_contador;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.Locale;

public class ContadorApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Locale.setDefault(Locale.US);

        // Ventana de Botones
        // Paso 1 - Necesitamos recuperar la vista del archivo .fxml
        //          PISTA: FXMLLoader(<CONTROLADOR>.class.getResource("<resources/path/<view>.fxml>"))
        FXMLLoader fxmlLoaderBotones = new FXMLLoader(
                ContadorBotonesController.class.getResource("contador-botones.fxml")
        );
        // Paso 2 - Creamos la escena principal (~ panel principal)
        //          PISTA: Scene(fxmlLoader.load(), <width>, <height>)
        Scene sceneBotones = new Scene(fxmlLoaderBotones.load(), 200, 200);
        // Paso 3 - Poner la escena en una venta (crear o usar algún Stage ~ frame principal)
        //          PISTA: Stage() | stage.setScene(scene) | stage.show()
        Stage stageBotones = new Stage();
        //        - Configuramos la venta (establecemos su escena principal y su título)
        stageBotones.setTitle("Contador Botones");
        stageBotones.setScene(sceneBotones);
        //       - Mostramos la ventana (mostramos el Stage ~ frame.setVisible(true))
        stageBotones.show();

        // Ventana de Labels
        FXMLLoader fxmlLoaderLabels = new FXMLLoader(ContadorLabelsController.class.getResource("contador-labels.fxml"));
        Scene sceneLabels = new Scene(fxmlLoaderLabels.load(), 200, 200);
        Stage stageLabels = new Stage();
        stageLabels.setTitle("Contador Labels");
        stageLabels.setScene(sceneLabels);

        // SUSCRIBIR LA VENTANA AL STORE
        ContadorLabelsController contadorLabelsController = fxmlLoaderLabels.getController();
        //ContadorStore.getInstance().suscribir(contadorLabelsController);

        stageLabels.setOnShowing(event -> {
            ContadorStore.getInstance().suscribir(contadorLabelsController);
        });

        stageLabels.setOnHidden(event -> {
            ContadorStore.getInstance().desuscribir(contadorLabelsController);
        });

        stageLabels.show();

    }
}
