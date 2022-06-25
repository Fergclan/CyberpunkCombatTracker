module com.example.cyberpunkcombattracker {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.cyberpunkcombattracker to javafx.fxml;
    exports com.example.cyberpunkcombattracker;
}