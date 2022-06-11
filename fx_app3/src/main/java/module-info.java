module com.example.fx_app3 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.fx_app3 to javafx.fxml;
    exports com.example.fx_app3;
}