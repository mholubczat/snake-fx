package org.example;

import java.io.IOException;
import javafx.fxml.FXML;

public class MenuController {

    @FXML
    private void newGame() throws IOException {
        App.setRoot("game");
    }

    @FXML
    private void highScores() throws IOException {
        App.setRoot("high-scores");
    }

    @FXML
    private void exit() throws IOException {

    }
}
