package com.teamglider.snake.objects;

import com.teamglider.snake.helpers.Position;

/**
 * A candy that feed my snake
 * Created by Guillaume Quittet on 13/12/16.
 */
public class Candy {

    private Position position;
    private int size;

    /**
     * A new Candy
     *
     * @param size     The size of the square
     * @param position The position of the square
     */
    public Candy(int size, Position position) {
        this.size = size;
        this.position = position;
    }

    /**
     * Return the positon of the candy
     * @return The size of the snake
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Set the position of the candy
     * @param position
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * Return the size of the candy
     * @return The size of the square
     */
    public int getSize() {
        return size;
    }
}
