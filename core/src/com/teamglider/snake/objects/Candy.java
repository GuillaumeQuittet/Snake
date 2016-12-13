package com.teamglider.snake.objects;

import com.teamglider.snake.helpers.Position;

/**
 * Created by Guillaume Quittet on 13/12/16.
 */
public class Candy {

    private Position position;
    private int size;

    public Candy(int size, Position position) {
        this.size = size;
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getSize() {
        return size;
    }
}
