package org.example.controller;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.*;
import javafx.util.Duration;
import org.example.model.Direction;

public class GameController {

    Direction nextDirection = Direction.RIGHT;
    Direction currentDirection = Direction.RIGHT;
    private final Duration STEP = Duration.millis(200);

    @FXML
    public Label initMsg;
    @FXML
    public Circle head;

    void start() {
        initMsg.setVisible(false);
        head.setVisible(true);
        move();
    }

    private KeyValue getDirection() {
        currentDirection = nextDirection;
        return switch (nextDirection) {
            case UP -> new KeyValue(head.translateYProperty(), head.getTranslateY() - 50);
            case DOWN -> new KeyValue(head.translateYProperty(), head.getTranslateY() + 50);
            case LEFT -> new KeyValue(head.translateXProperty(), head.getTranslateX() - 50);
            case RIGHT -> new KeyValue(head.translateXProperty(), head.getTranslateX() + 50);
        };
    }

    private void move() {
        Timeline timeline = new Timeline(new KeyFrame(STEP, e -> move(), getDirection()));
        timeline.play();
    }
}


