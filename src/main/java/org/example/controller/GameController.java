package org.example.controller;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController {

    private boolean right = true;
    private boolean left = false;
    private boolean up = false;
    private boolean down = false;
    @FXML
    public StackPane gamePane;
    @FXML
    public Label initMsg;
    @FXML
    public Circle head;

    void up() {
        this.up = true;
        this.down = false;
        this.left = false;
        this.right = false;
    }

    void down() {
        this.up = false;
        this.down = true;
        this.left = false;
        this.right = false;
    }

    void left() {
        this.up = false;
        this.down = false;
        this.left = true;
        this.right = false;
    }

    void right() {
        this.up = false;
        this.down = false;
        this.left = false;
        this.right = true;
    }

    void start() {
        System.out.println("START");
        initMsg.setVisible(false);
        head.setVisible(true);
        move();
    }

    private void move() {
        KeyValue goRight = new KeyValue(head.translateXProperty(), 200);
        KeyValue goUp = new KeyValue(head.translateYProperty(), 200);
        KeyValue goLeft = new KeyValue(head.translateXProperty(), -200);
        KeyValue goDown = new KeyValue(head.translateYProperty(), -200);
        System.out.println("1");
        while (right && head.isVisible()) {
            System.out.println("2");
            new KeyFrame(
                    Duration.millis(500),
                    goRight
            );
        }
        while (left && head.isVisible()) {
            new KeyFrame(
                    Duration.millis(500),
                    goLeft
            );
        }
        while (up && head.isVisible()) {
            new KeyFrame(
                    Duration.millis(500),
                    goUp
            );
        }
        while (down && head.isVisible()) {
            new KeyFrame(
                    Duration.millis(500),
                    goDown
            );
        }
    }
}

