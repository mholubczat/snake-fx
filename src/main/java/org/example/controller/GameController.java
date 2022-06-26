package org.example.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.example.App;

import java.io.IOException;

import static org.example.App.loadFXML;

public class GameController {


    @FXML
    TextField horizontal;
    @FXML
    TextField vertical;

    @FXML
    private void exit() throws IOException {

    }


    @FXML
    private void startGame() throws IOException {
        Stage game = new Stage();
        game.setScene(new Scene(loadFXML("game"), 320, 240));
        game.show();
    }
}
