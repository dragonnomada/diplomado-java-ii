package com.example.fx_app6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TodoApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(TodoListController.class.getResource("todo-list-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 500, 500);

        stage.setScene(scene);
        stage.setTitle("Todo List");

        stage.show();

    }
}
