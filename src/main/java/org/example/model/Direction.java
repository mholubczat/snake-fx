package org.example.model;

public enum Direction {

    UP (0,-1),
    DOWN (0,1),
    LEFT (-1, 0),
    RIGHT (1, 0);

    private final int X;
    private final int Y;

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    Direction(int x, int y) {
        this.X = x;
        this.Y = y;
    }
}
