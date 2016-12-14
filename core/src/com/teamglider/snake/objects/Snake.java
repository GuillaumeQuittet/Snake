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

    public int getSize() {
        return size;
    }

    public int getLength() {
        return length;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        if (canChangeDirection) {
            this.direction = direction;
            canChangeDirection = false;
        }
    }

    public void addPosition(Position position) {
        try {
            positions[length] = position;
            length += 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            Gdx.app.log("Game end", e.getMessage());
        }
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Position[] getPositions() {
        return positions;
    }

    public Position getHead() {
        return positions[0];
    }
}
