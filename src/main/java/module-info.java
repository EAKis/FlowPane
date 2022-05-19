module com.example.flowpane {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.flowpane to javafx.fxml;
    exports com.example.flowpane;

}