module com.example.taller6_1_contador {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.taller6_1_contador to javafx.fxml;
    exports com.example.taller6_1_contador;
}