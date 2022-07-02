module org.example {
    requires javafx.controls;
    requires javafx.fxml;

    exports org.example;
    exports org.example.model;
    opens org.example.controller to javafx.fxml;
    opens org.example.model to javafx.fxml;
}
