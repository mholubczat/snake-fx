package org.example.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;

public class GameController {

    @FXML
    public StackPane gamePane;
    @FXML
    public Label initMsg;
    @FXML
    public Circle head;

    void up() {
        if (head.isVisible()) {
            System.out.println("UP");
        }
    }
    void down() {
        if (head.isVisible()) {
            System.out.println("DOWN");
        }
    }

    void left() {
        if (head.isVisible()) {
            System.out.println("LEFT");
        }
    }

    void right() {
        if (head.isVisible()) {
            System.out.println("RIGHT");
        }
    }

    void start() {
        System.out.println("START");
        head.setVisible(true);
        initMsg.setVisible(false);
        head.setVisible(true);
    }

}

