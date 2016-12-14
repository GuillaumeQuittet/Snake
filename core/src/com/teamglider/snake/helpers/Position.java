package com.teamglider.snake.helpers;

/**
 * The position
 * Created by Guillaume Quittet on 12/12/16.
 */
public class Position {

    private float x;
    private float y;

    /**
     * A new position
     *
     * @param x The x coordinate of the position
     * @param y The y coordinate of the position
     */
    public Position(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Return the x coordinate
     * @return The x coordinate
     */
    public float getX() {
        return x;
    }

    /**
     * Set the x coordinate
     * @param x The x coordinate
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * Return the y coordinate
     * @return The y coordinate
     */
    public float getY() {
        return y;
    }

    /**
     * Set the y coordinate
     * @param y The y coordinate
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * Equals two positions
     * @param position The second position
     * @return True or false. It depends of the equality.
     */
    public boolean equals(Position position) {
        if (this.x == position.getX() && this.y == position.getY())
            return true;
        else
            return false;
    }

    /**
     * The text representation of the position
     * @return The text representation of the position
     */
    public String toString() {
        return "Position: " + Float.toString(x) + " : " + Float.toString(y);
    }
}
