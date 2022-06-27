package org.example.controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static org.example.App.loadFXML;
import static org.example.controller.GameController.*;


public class InitGameController {

    @FXML
    private TextField hSize;
    @FXML
    private TextField vSize;
    @FXML
    private Label wrongSizeErrMsg;

    @FXML
    private void initGame() {
        try {
            // if parse int unsuccessful exception is raised
            int width = Integer.parseInt(hSize.getText());
            int height = Integer.parseInt(vSize.getText());
            if (width < 240 || height < 240 || width > 1920 || height > 1200) throw new RuntimeException();
            // no exception -> open game window
            initializeGameWindow(width, height);
            // no exception -> close this window
            Stage initWindow = (Stage) hSize.getScene().getWindow();
            initWindow.close();
        } catch (RuntimeException | IOException e) {
            wrongSizeErrMsg.setVisible(true);
        }
    }

    private void initializeGameWindow(int width, int height) throws IOException {
        Stage gameStage = new Stage();
        Scene gameScene = new Scene(loadFXML("game"), width, height);
       /* gameScene.setOnKeyPressed(
                e -> {
                    switch (e.getCode()) {
                        case UP, W -> up();
                        case DOWN, S -> down();
                        case LEFT, A -> left();
                        case RIGHT, D -> right();
                        case ENTER -> start();
                    }
                }
        );*/
        gameStage.setScene(gameScene);
        gameStage.show();
    }
}

