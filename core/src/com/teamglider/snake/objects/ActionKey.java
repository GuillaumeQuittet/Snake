package com.teamglider.snake.objects;

import com.teamglider.snake.helpers.Position;

/**
 * An action key
 * Created by Guillaume Quittet on 11/12/16.
 */
public class ActionKey {

    // Rotation is between 0 and 3
    // 0: right 1: down
    // 2: left 3: up
    private int rotation;
    private float size;
    private Position position;

    /**
     * Create an aciton key
     *
     * @param rotation The rotation of the action key
     * @param size     The size of the square that form the action key
     * @param position The position of the action key
     */
    public ActionKey(int rotation, float size, Position position) {
        this.rotation = rotation;
        this.size = size;
        this.position = position;
    }

    /**
     * Return the rotation of the candy
     * @return The rotation of the candy
     */
    public int getRotation() {
        return rotation;
    }

    /**
     * Return the position of the candy
     * @return The position of the candy
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Return the size of the candy
     * @return The size of the candy
     */
    public float getSize() {
        return size;
    }
}
