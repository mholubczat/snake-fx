package org.example;

import java.io.IOException;
import javafx.fxml.FXML;

public class ScoresController {

    @FXML
    private void backToMenu() throws IOException {
        App.setRoot("main-menu");
    }
}