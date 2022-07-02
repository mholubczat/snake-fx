package org.example.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.App;
import org.example.model.Direction;
import org.example.model.WindowSizeException;

import java.io.IOException;

public class InitGameController {

    @FXML
    private TextField hSize;
    @FXML
    private TextField vSize;
    @FXML
    private Label wrongSizeErrMsg;
    static double width;
    static double height;

    @FXML
    private void initGame() {
        try {
            // if parse int unsuccessful exception is raised
            int width = Integer.parseInt(hSize.getText());
            int height = Integer.parseInt(vSize.getText());
            if (width < 240 || height < 240 || width > 1920 || height > 1200) throw new WindowSizeException("Incorrect window size. Must be 240-1920 x 240-1200");
            // no exception -> open game window
            initializeGameWindow(width, height);
            InitGameController.width = width;
            InitGameController.height = height;
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
                        case UP, W -> {
                            if (!controller.currentDirection.equals(Direction.DOWN))
                                controller.nextDirection = Direction.UP;
                        }
                        case DOWN, S -> {
                            if (!controller.currentDirection.equals(Direction.UP))
                                controller.nextDirection = Direction.DOWN;
                        }
                        case LEFT, A -> {
                            if (!controller.currentDirection.equals(Direction.RIGHT))
                                controller.nextDirection = Direction.LEFT;
                        }
                        case RIGHT, D -> {
                            if (!controller.currentDirection.equals(Direction.LEFT))
                                controller.nextDirection = Direction.RIGHT;
                        }
                        case ENTER -> {
                            if (controller.initMsg.isVisible()) {
                                try {
                                    controller.start();
                                } catch (IOException | InterruptedException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                        }
                    }
                }
        );
        gameStage.setOnCloseRequest(e -> controller.dead=true);
        gameStage.setScene(gameScene);
        gameStage.show();
    }
}


