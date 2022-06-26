package org.example.controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    private void exit() throws IOException {

    }


    @FXML
    private void startGame() throws IOException {
        Stage game = new Stage();
        int width = 0;
        int height = 0;
        try {
            width = Integer.parseInt(horizontal.getText());
            height = Integer.parseInt(vertical.getText());
            if(width < 240 || height < 240 || width > 1920 || height > 1200) throw new NumberFormatException();
            game.setScene(new Scene(loadFXML("game"), width, height));
            game.show();
            Stage currentWindow = (Stage) horizontal.getScene().getWindow();
            currentWindow.close();
        }  catch (NumberFormatException e) {
            numberFormatErrMsg.setVisible(true);
        }
    }
}
