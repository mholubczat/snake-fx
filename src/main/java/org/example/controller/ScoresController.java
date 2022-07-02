package org.example.controller;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.App;
import org.example.model.Score;

public class ScoresController implements Initializable {
    @FXML
    private TableColumn<Score, String> name;
    @FXML
    private TableColumn<Score, Integer> score;
    @FXML
    private TableView<Score> highScores;

    @FXML
    private void backToMenu() throws IOException {
        App.setRoot("main-menu");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        score.setCellValueFactory(new PropertyValueFactory<>("score"));

        try {
            Score readScore;
            FileInputStream fis
                    = new FileInputStream("highScores.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            while ((readScore = (Score) ois.readObject()) != null) {
                highScores.getItems().add(readScore);
            }
        } catch (IOException | ClassNotFoundException ignored) {
        } finally {
            highScores.getItems().sort((o1, o2) -> o2.getScore() - o1.getScore());
        }
    }
}