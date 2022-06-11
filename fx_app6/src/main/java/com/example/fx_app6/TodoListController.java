package com.example.fx_app6;

import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

import java.util.HashMap;
import java.util.Map;

public class TodoListController {

    @FXML
    private TableView todoListTable;

    @FXML
    private TableColumn column1;
    @FXML
    private TableColumn column2;
    @FXML
    private TableColumn column3;
    @FXML
    private TableColumn column4;

    @FXML
    protected void initialize() {
        //column1.setCellValueFactory(cellData -> new ReadOnlyBooleanWrapper(((TableColumn.CellDataFeatures<Todo, Boolean>)cellData).getValue().isCompletado()));
        //column1.setCellValueFactory(new PropertyValueFactory<>( "completado" ));
        column1.setCellValueFactory(c -> new SimpleBooleanProperty(((TableColumn.CellDataFeatures<Todo, Boolean>)c).getValue().isCompletado()));
        /*column1.setCellValueFactory(c -> {
            Todo todo = ((TableColumn.CellDataFeatures<Todo, Boolean>)c).getValue();
            CheckBox checkBox = new CheckBox();
            //System.out.println(todo);
            //System.out.println(todo.isCompletado());
            checkBox.setSelected(todo.isCompletado());
            checkBox.selectedProperty()
                    .addListener((ov, old_val, new_val) -> {
                        System.out.printf("old: %B new: %B\n", old_val, new_val);
                        todo.setCompletado(new_val);
                    });
            //return new SimpleObjectProperty(checkBox);
            return new SimpleBooleanProperty(todo.isCompletado());
        });*/
        column1.setCellFactory(tc -> new CheckBoxTableCell<>());

        column2.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        column2.setCellFactory(TextFieldTableCell.<Todo>forTableColumn());

        column3.setCellValueFactory(new PropertyValueFactory<>("fechaCreado"));
        column3.setCellFactory(TextFieldTableCell.<Todo>forTableColumn());

        column4.setCellValueFactory(new PropertyValueFactory<>("fechaCompletado"));
        column4.setCellFactory(TextFieldTableCell.<Todo>forTableColumn());

        todoListTable.getItems().add(new Todo(true, "Algo", "a", "b"));
        todoListTable.getItems().add(new Todo(false, "Otro", "x", "y"));
    }

    @FXML
    protected void onTableClick(MouseEvent event) {
        if (event.getClickCount() == 2) {
            System.out.println(event.getClickCount());
            TablePosition tablePosition = todoListTable.getFocusModel().getFocusedCell();
            Todo todo = (Todo) todoListTable.getItems().get(tablePosition.getRow());
            System.out.println(todo);
        }
    }

}
