package com.teamglider.snake.objects;

import com.teamglider.snake.helpers.Position;

/**
 * Created by Guillaume Quittet on 11/12/16.
 */
public class ActionKey {

    // Rotation is between 0 and 3
    // 0: right 1: down
    // 2: left 3: up
    private int rotation;
    private float size;
    private Position position;

    public ActionKey(int rotation, float size, Position position) {
        this.rotation = rotation;
        this.size = size;
        this.position = position;
    }

    public int getRotation() {
        return rotation;
    }

    public Position getPosition() {
        return position;
    }

    public float getSize() {
        return size;
    }
}
