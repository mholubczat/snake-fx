package org.example.controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

import static org.example.App.loadFXML;

public class GameController {
    
    @FXML
    TextField hSize;
    @FXML
    TextField vSize;
    @FXML
    Label wrongSizeErrMsg;
    @FXML
    Label initMsg;
    @FXML
    Circle head;
    @FXML
    public void initialize(){

    }
    @FXML
    private void startGame() throws IOException {
        Stage game = new Stage();
        try {
            // if parse int unsuccessful exception is raised
            int width = Integer.parseInt(hSize.getText());
            int height = Integer.parseInt(vSize.getText());
            if (width < 240 || height < 240 || width > 1920 || height > 1200) throw new RuntimeException();
            // no exception -> open game window
            game.setScene(gameScene(width, height));
            game.show();
            // close init window
            Stage initWindow = (Stage) hSize.getScene().getWindow();
            initWindow.close();
        } catch (RuntimeException e) {
            wrongSizeErrMsg.setVisible(true);
        }
    }

    private Scene gameScene(int width, int height) throws IOException {
        Scene gameScene = new Scene(loadFXML("game"), width, height);
        gameScene.setOnKeyPressed(
                e -> {
                    switch (e.getCode()) {
                        case UP, W -> up();
                        case DOWN, S -> down();
                        case LEFT, A -> left();
                        case RIGHT, D -> right();
                        case ENTER -> start();
                    }
                }
        );
        return gameScene;
    }
    private void up() {
        if (head.isVisible()) {
            System.out.println("UP we go");
        }
    }
    private void down() {
        if (head.isVisible()) {
            System.out.println("UP we go");
        }
    }

    private void left() {
        if (head.isVisible()) {
            System.out.println("UP we go");
        }
    }

    private void right() {
        if (head.isVisible()) {
            System.out.println("UP we go");
        }
    }

    private void start() {
        head.setVisible(true);
        initMsg.setVisible(false);
        head.setVisible(true);
    }

}

