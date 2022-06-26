module org.example {
    requires javafx.controls;
    requires javafx.fxml;

    exports org.example;
    opens org.example.controller to javafx.fxml;
}
