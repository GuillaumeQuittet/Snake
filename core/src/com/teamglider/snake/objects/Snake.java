package com.teamglider.snake.objects;

import com.badlogic.gdx.Gdx;
import com.teamglider.snake.helpers.Position;

/**
 * Created by Guillaume Quittet on 12/12/16.
 */
public class Snake {

    private int size;
    // The direction of the Snake
    // 0: right 1: down
    // 2: left 3: up
    private int direction;
    private Position[] positions;
    private int length;
    private int speed;
    private boolean canChangeDirection;

    /**
     * The Snake
     *
     * @param size      The size of the snake
     * @param length    The maximum length of the snake
     * @param speed     The speed of the snake
     * @param positions The first part of the snake
     */
    public Snake(int size, int length, int speed, Position[] positions) {
        this.size = size;
        this.speed = speed;
        this.positions = new Position[length];
        canChangeDirection = true;
        direction = 2;
        this.length = 0;
        for (Position position:positions) {
            addPosition(position);
        }
    }

    /**
     * Move forward the snake
     * @param delta The mother's delta
     */
    public void update(float delta) {
        Position posTemp;
        for (int i = length - 1; i > 0; i--) {
            posTemp = positions[i];
            positions[i] = positions[i-1];
            positions[i-1] = posTemp;
        }
        if (direction == 0)
            positions[0] = new Position(positions[1].getX() + size, positions[1].getY());
        else if (direction == 1)
            positions[0] = new Position(positions[1].getX(), positions[1].getY() + size);
        else if (direction == 2)
            positions[0] = new Position(positions[1].getX() - size, positions[1].getY());
        else if (direction == 3)
            positions[0] = new Position(positions[1].getX(), positions[1].getY() - size);
        canChangeDirection = true;
    }

    /**
     * Eat a candy and increase the length of the snake
     * @param candy A candy
     */
    public void eatCandy(Candy candy) {
        switch (direction) {
            case 0:
                addPosition(new Position(positions[length - 1].getX() - size, positions[length - 1].getY()));
                break;
            case 1:
                addPosition(new Position(positions[length - 1].getX(), positions[length - 1].getY() - size));
                break;
            case 2:
                addPosition(new Position(positions[length - 1].getX() + size, positions[length - 1].getY()));
                break;
            case 3:
                addPosition(new Position(positions[length - 1].getX(), positions[length - 1].getY() + size));
                break;
        }
    }

    /**
     * Return the size of the snake.
     * @return size The size of one part of the snake
     */
    public int getSize() {
        return size;
    }

    /**
     * Return the current length of the snake
     * @return length The current length of the snake
     */
    public int getLength() {
        return length;
    }

    /**
     * Return the current direction that the snake is moving from it(0:right, 1: down, 2:left, 3:up)
     * @return direction The direction of the snake
     */
    public int getDirection() {
        return direction;
    }

    /**
     * Set the snake direction
     * @param direction The snake direction
     */
    public void setDirection(int direction) {
        if (canChangeDirection) {
            this.direction = direction;
            canChangeDirection = false;
        }
    }

    /**
     * Add a part of the snake.
     * @param position A part of the snake
     */
    public void addPosition(Position position) {
        try {
            positions[length] = position;
            length += 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            Gdx.app.log("Game end", e.getMessage());
        }
    }

    /**
     * Return the current speed of the snake
     * @return speed The current speed of the snake
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Set the speed of the snake
     * @param speed The speed of the snake
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * Return the parts of the snake
     * @return positions The parts of the snake
     */
    public Position[] getPositions() {
        return positions;
    }

    /**
     * Return the head of the snake
     * @return position[0] The head of the snake and also the first element of the table.
     */
    public Position getHead() {
        return positions[0];
    }

    /**
     * Empty the positions tables
     */
    private void emptyPositions() {
        direction = 2;
        for (int i = 0; i < length; ++i) {
            positions[i] = null;
            length = 0;
        }
    }

    /**
     * Set a new table that contains new part of the snake inside
     * @param positions The table of the snake
     * @param length The length of this table
     */
    public void setPositions(Position[] positions, int length) {
        emptyPositions();
        for (int i = 0; i < length; ++i) {
            addPosition(positions[i]);
        }
    }
}
