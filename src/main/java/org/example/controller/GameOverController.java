package org.example.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.exception.NoNameException;
import org.example.model.Score;

import java.io.*;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import static org.example.controller.GameController.food;
import static org.example.controller.GameController.time;
import static org.example.controller.InitGameController.height;
import static org.example.controller.InitGameController.width;

public class GameOverController implements Initializable {

    @FXML
    public Label noNameErr;
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


    private final int SCORE = (int) (food * 10 + time * 10 * 240 * 240 / width / height);

    @FXML
    public void saveScore() throws IOException {
        if (player.getText().isBlank()) {
            this.noNameErr.setVisible(true);
            throw new NoNameException("No name entered!");
        } else {
            List<Score> highScores = null;
            try {
                highScores = new LinkedList<>();
                Score readScore;
                FileInputStream fis
                        = new FileInputStream("highScores.txt");
                ObjectInputStream ois = new ObjectInputStream(fis);
                while ((readScore = (Score) ois.readObject()) != null) {
                    highScores.add(readScore);
                }
                ois.close();
            } catch (IOException | ClassNotFoundException ignored) {

            }
            FileOutputStream fos
                    = new FileOutputStream("highScores.txt");
            ObjectOutputStream oos
                    = new ObjectOutputStream(fos);
            for (Score s : highScores) oos.writeObject(s);
            oos.writeObject(new Score(player.getText(), SCORE));
            ((Stage) player.getScene().getWindow()).close();
            oos.close();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        foodScore.setText(String.format("%.0f", food * 10));
        timeScore.setText(String.format("%.0f", time * 10));
        windowScore.setText(String.format("%.2f", 240 * 240 / width / height));
        total.setText(String.format("%.0f", food * 10) + " + " + String.format("%.0f", time * 10) + " x "
                + String.format("%.2f", 240 * 240 / width / height) + " = " + String.format("%d", SCORE));
    }
}
