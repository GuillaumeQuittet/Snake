package com.teamglider.snake.helpers;

/**
 * Created by Guillaume Quittet on 12/12/16.
 */
public class Position {

    private float x;
    private float y;

    public Position(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public String toString() {
        return "Position: " + Float.toString(x) + " : " + Float.toString(y);
    }
}
