package org.example.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import org.example.App;

public class ScoresController {

    @FXML
    private void backToMenu() throws IOException {
        App.setRoot("main-menu");
    }
}