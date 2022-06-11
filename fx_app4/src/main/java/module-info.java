module com.example.fx_app4 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.fx_app4 to javafx.fxml;
    exports com.example.fx_app4;
}