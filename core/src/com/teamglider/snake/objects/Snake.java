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

    public Snake(int size, int length, Position[] positions) {
        this.size = size;
        this.positions = new Position[length];
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
    }

    public void eatCandy(Candy candy) {
        switch (getMoveDirection()) {
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

    public int getMoveDirection() {
        int direction;
        float x1 = positions[length - 1].getX();
        float x2 = positions[length - 2].getX();
        float deltaX = x2 - x1;
        float y1 = positions[length - 1].getY();
        float y2 = positions[length - 2].getY();
        float deltaY = y2 - y1;
        if (deltaX == 0) {
            if (deltaY > 0)
                direction = 1;
            else
                direction = 3;
        } else {
            if (deltaX < 0)
                direction = 0;
            else
                direction = 2;
        }
        return direction;
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
        this.direction = direction;
    }

    public void addPosition(Position position) {
        try {
            positions[length] = position;
            length += 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            Gdx.app.log("Game end", e.getMessage());
        }
    }

    public Position[] getPositions() {
        return positions;
    }

    public Position getHead() {
        return positions[0];
    }
}
