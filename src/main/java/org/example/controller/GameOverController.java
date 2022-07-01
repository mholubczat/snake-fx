package org.example.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static org.example.controller.GameController.food;
import static org.example.controller.GameController.time;
import static org.example.controller.InitGameController.height;
import static org.example.controller.InitGameController.width;

public class GameOverController implements Initializable {


    @FXML
    private TextField player;
    @FXML
    private Label total;
    @FXML
    private Label timeScore;
    @FXML
    private Label foodScore;
    @FXML
    private Label windowScore;


    private final int SCORE = (int)(food*10 + time*10*240*240/width/height);
    @FXML
    public void saveScore() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        foodScore.setText(String.format("%.0f",food*10));
        timeScore.setText(String.format("%.0f",time*10));
        windowScore.setText(String.format("%.2f",240*240/width/height));
        total.setText(String.format("%.0f",food*10)+" + " + String.format("%.0f",time*10) + " x "
                + String.format("%.2f",240*240/width/height) + " = " +String.format("%d",SCORE));
    }
}
