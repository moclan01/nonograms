module com.example {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example to javafx.fxml;
    exports com.example;

    opens com.example.controllers to javafx.fxml;
    exports com.example.controllers;
}
