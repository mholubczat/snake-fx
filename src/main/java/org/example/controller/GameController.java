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

import java.util.*;
import java.util.function.Function;

import static org.example.controller.InitGameController.heigth;
import static org.example.controller.InitGameController.width;

public class GameController {
    @FXML
    public StackPane pane;
    Direction nextDirection = Direction.RIGHT;
    Direction currentDirection = Direction.RIGHT;
    private final Duration SPEED = Duration.millis(200);
    private final int STEP = 20;
    private final Set<Circle> FOODS = new HashSet<>();
    private final LinkedList<Circle> SNAKE = new LinkedList<>();
    private final Set<Circle> EATEN = new HashSet<>();

    @FXML
    public Label initMsg;
    @FXML
    public Circle head;

    void start() {
        initMsg.setVisible(false);
        head.setVisible(true);
        SNAKE.add(head);
        DIRECTIONS.add(currentDirection);
        System.out.println(SNAKE);
        System.out.println(SNAKE.getLast());
        addFood();
        move();
    }

    private final LinkedList<Direction> DIRECTIONS = new LinkedList<>();

    private KeyFrame getKeyFrame(Circle circle, Direction direction) {
        return new KeyFrame(SPEED, new KeyValue(circle.translateXProperty(), circle.getTranslateX() + STEP * direction.getX()), new KeyValue(circle.translateYProperty(), circle.getTranslateY() + STEP * direction.getY()));
    }

    private KeyFrame getHeadKeyFrame(Circle circle, Direction direction) {
        return new KeyFrame(SPEED,
                e -> {
                    // consume food
                    consumeFood();
                    //Coordinates

                    // next move
                    move();
                },
                new KeyValue(circle.translateXProperty(), circle.getTranslateX() + STEP * direction.getX()), new KeyValue(circle.translateYProperty(), circle.getTranslateY() + STEP * direction.getY()));
    }

    private void move() {
        if (Math.random() > 0.95)
            addFood();
        currentDirection = nextDirection;
        DIRECTIONS.addFirst(currentDirection);
        DIRECTIONS.removeLast();
        Timeline timeline = new Timeline(getHeadKeyFrame(head, currentDirection));
        drawBodySegments(timeline);
        //  timeline.getKeyFrames().add(new KeyFrame(SPEED,))
        timeline.play();

    }

    private void drawBodySegments(Timeline timeline) {
        for (int i = 1; i < DIRECTIONS.size(); i++) {
                timeline.getKeyFrames().add(getKeyFrame(SNAKE.get(i), DIRECTIONS.get(i)));
        }
    }


    private void consumeFood() {
        FOODS.stream().filter(
                f -> f.getBoundsInParent().intersects(head.getBoundsInParent())
        ).forEach(f -> {
            pane.getChildren().remove(f);
            EATEN.add(f);
            if (f.getFill().equals(Color.GREEN)) {
                Circle newSegment = new Circle(10, Color.OLIVE);
                newSegment.setTranslateX(SNAKE.getLast().getTranslateX() - STEP * DIRECTIONS.getLast().getX());
                newSegment.setTranslateY(SNAKE.getLast().getTranslateY() - STEP * DIRECTIONS.getLast().getY());
                DIRECTIONS.addLast(DIRECTIONS.getLast());
                SNAKE.add(newSegment);
                pane.getChildren().add(newSegment);
            } else if (SNAKE.size() > 1) {
                pane.getChildren().remove(SNAKE.getLast());
                SNAKE.removeLast();
                DIRECTIONS.removeLast();
            }
        });
        FOODS.removeAll(EATEN);
    }

    private void addFood() {
        Circle food = new Circle(5);
        food.setTranslateX((int) ((Math.random() - 0.5) * (width - 10)));
        food.setTranslateY((int) ((Math.random() - 0.5) * (heigth - 10)));
        this.FOODS.add(food);
        if (Math.random() > 0.8) {
            food.setFill(Color.GOLD);
        } else food.setFill(Color.GREEN);
        pane.getChildren().add(food);
    }


}


