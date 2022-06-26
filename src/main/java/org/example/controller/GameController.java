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
    TextField horizontal;
    @FXML
    TextField vertical;
    @FXML
    Label numberFormatErrMsg;

    @FXML
    Circle head;

    @FXML
    private void startGame() throws IOException {
        Stage game = new Stage();
        int width = 0;
        int height = 0;
        try {
            // if parse int unsuccessful exception is raised
            width = Integer.parseInt(horizontal.getText());
            height = Integer.parseInt(vertical.getText());
            if (width < 240 || height < 240 || width > 1920 || height > 1200) throw new RuntimeException();
            // no exception -> open game window
            game.setScene(gameScene(width,height));
            game.show();
            // close init window
            Stage initWindow = (Stage) horizontal.getScene().getWindow();
            initWindow.close();
        } catch (RuntimeException e) {
            numberFormatErrMsg.setVisible(true);
        }
    }

    private void up(){
        System.out.println("UP we go");
    }
    private void down(){
        System.out.println("down we go");
    }

    private void left(){
        System.out.println("left we go");
    }
    private void right(){
        System.out.println("right we go");
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
                    }
                }
        );

        return gameScene;
    }

}

