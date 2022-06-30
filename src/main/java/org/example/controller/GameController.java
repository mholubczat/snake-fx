package org.example.controller;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.util.Duration;
import org.example.model.Direction;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import static org.example.controller.InitGameController.heigth;
import static org.example.controller.InitGameController.width;

public class GameController {
    @FXML
    public StackPane pane;
    Direction nextDirection = Direction.RIGHT;
    Direction currentDirection = Direction.RIGHT;
    private final Duration SPEED = Duration.millis(200);
    private final int STEP = 20;
    private Set<Circle> foods = new HashSet<>();
    private LinkedList<Circle> snake = new LinkedList<>();
    @FXML
    public Label initMsg;
    @FXML
    public Circle head;

    void start() {
        initMsg.setVisible(false);
        head.setVisible(true);
        snake.add(head);
        addFood();
        move();
    }

    private KeyValue getDirection() {
        currentDirection = nextDirection;
        return switch (nextDirection) {
            case UP -> new KeyValue(head.translateYProperty(), head.getTranslateY() - STEP);
            case DOWN -> new KeyValue(head.translateYProperty(), head.getTranslateY() + STEP);
            case LEFT -> new KeyValue(head.translateXProperty(), head.getTranslateX() - STEP);
            case RIGHT -> new KeyValue(head.translateXProperty(), head.getTranslateX() + STEP);
        };
    }

    private void move() {
        if (Math.random() > 0.95)
            addFood();
        Timeline timeline = new Timeline(
                new KeyFrame(SPEED,
                        e -> {
                            foods.stream().filter(
                                    f->f.getBoundsInParent().intersects(head.getBoundsInParent())
                            ).forEach(f->{
                                pane.getChildren().remove(f);
                                if(f.getFill().equals(Color.GREEN)) snake.add(new Circle(5,Color.OLIVE));
                                else if (snake.size()>1) snake.removeLast();
                            });
                            move();
                        },
                        getDirection()));
        timeline.play();

    }

    private void addFood() {
        Circle food = new Circle(5);
        food.setTranslateX((int) ((Math.random() - 0.5) * (width - 10)));
        food.setTranslateY((int) ((Math.random() - 0.5) * (heigth - 10)));
        this.foods.add(food);
        if (Math.random() > 0.9) {food.setFill(Color.GOLD);}
        else food.setFill(Color.GREEN);
        pane.getChildren().add(food);
    }

    private void gainMass(){

    }
}


