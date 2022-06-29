package org.example.controller;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import org.example.model.Direction;

public class GameController {

    Direction direction = Direction.RIGHT;
    private final Duration STEP = Duration.millis(1500);

    @FXML
    public Label initMsg;
    @FXML
    public Circle head;

    void up() {
        if (!direction.equals(Direction.DOWN)) direction = Direction.UP;
    }

    void down() {
        if (!direction.equals(Direction.UP)) direction = Direction.DOWN;
    }

    void left() {
        if (!direction.equals(Direction.RIGHT)) direction = Direction.LEFT;
    }


    void right() {
        if (!direction.equals(Direction.LEFT)) direction = Direction.RIGHT;
    }

    void start(){
        System.out.println("START");
        initMsg.setVisible(false);
        head.setVisible(true);
    }

    private KeyValue getDirection() {
        return switch (direction) {
            case UP -> new KeyValue(head.translateYProperty(), 10);
            case DOWN -> new KeyValue(head.translateYProperty(), -10);
            case LEFT -> new KeyValue(head.translateXProperty(), -10);
            case RIGHT -> new KeyValue(head.translateXProperty(), 10);
        };
    }


    private void move() {
        Timeline timeline = new Timeline(new KeyFrame(STEP, getDirection()));
        timeline.play();
    }
}

