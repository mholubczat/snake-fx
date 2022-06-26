package org.example.controller;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.App;

import static org.example.App.loadFXML;

public class MenuController {

    @FXML
    private void newGame() throws IOException {
        Stage initGame = new Stage();
        initGame.setScene(new Scene(loadFXML("init-game"), 320, 240));
        initGame.show();
    }

    @FXML
    private void highScores() throws IOException {
        App.setRoot("high-scores");
    }

    @FXML
    private void exit(){
        Platform.exit();
    }
}
