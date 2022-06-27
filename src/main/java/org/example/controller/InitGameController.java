package org.example.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.App;

import java.io.IOException;

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
            e.printStackTrace();
        }
    }

    private void initializeGameWindow(int width, int height) throws IOException {
        Stage gameStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("game.fxml"));
        Scene gameScene = new Scene(fxmlLoader.load(), width, height);
        GameController controller = fxmlLoader.getController();
        gameScene.setOnKeyPressed(
                e -> {
                    switch (e.getCode()) {
                        case UP, W -> controller.up();
                        case DOWN, S -> controller.down();
                        case LEFT, A -> controller.left();
                        case RIGHT, D -> controller.right();
                        case ENTER -> controller.start();
                    }
                }
        );
        gameStage.setScene(gameScene);
        gameStage.show();
    }
}


