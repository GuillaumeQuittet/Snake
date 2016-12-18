package com.teamglider.snake.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.teamglider.snake.helpers.Position;

/**
 * Snake
 * Created by Guillaume Quittet on 12/12/16.
 */
public class Snake extends GameObject {

    // The direction of the Snake
    // 0: right 1: down
    // 2: left 3: up
    private int direction;
    private Position[] initPositions;
    private int positionLength;
    private Position[] positions;
    private int length;
    private int maxLength;
    private float speed;
    private float initSpeed;
    private boolean canChangeDirection;

    /**
     * The Snake
     *
     * @param size      The size of the snake
     * @param maxLength The maximum length of the snake
     * @param speed     The speed of the snake
     * @param positions The first part of the snake
     */
    public Snake(int size, int maxLength, float speed, Position[] positions, int positionLength) {
        super(size);
        this.speed = speed;
        this.initSpeed = speed;
        this.maxLength = maxLength;
        this.positions = new Position[maxLength];
        this.positionLength = positionLength;
        this.initPositions = positions;
        canChangeDirection = true;
        direction = 2;
        this.length = 0;
        setColor(new Color(1, 1, 1, 1));
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
            positions[0] = new Position(positions[1].getX() + getSize(), positions[1].getY());
        else if (direction == 1)
            positions[0] = new Position(positions[1].getX(), positions[1].getY() + getSize());
        else if (direction == 2)
            positions[0] = new Position(positions[1].getX() - getSize(), positions[1].getY());
        else if (direction == 3)
            positions[0] = new Position(positions[1].getX(), positions[1].getY() - getSize());
        canChangeDirection = true;
    }

    /**
     * Eat a candy and increase the length of the snake
     * @param candy A candy
     */
    public void eatCandy(Candy candy, Score score) {
        switch (direction) {
            case 0:
                addPosition(new Position(positions[length - 1].getX() - getSize(), positions[length - 1].getY()));
                break;
            case 1:
                addPosition(new Position(positions[length - 1].getX(), positions[length - 1].getY() - getSize()));
                break;
            case 2:
                addPosition(new Position(positions[length - 1].getX() + getSize(), positions[length - 1].getY()));
                break;
            case 3:
                addPosition(new Position(positions[length - 1].getX(), positions[length - 1].getY() + getSize()));
                break;
        }
        if ((candy.getPosition().getX() < candy.getSize() && (candy.getPosition().getY() < candy.getSize() || candy.getPosition().getY() >= getViewWidth() - candy.getSize())) || (candy.getPosition().getX() >= getViewWidth() - candy.getSize() && (candy.getPosition().getY() < candy.getSize() || candy.getPosition().getY() >= getViewWidth() - candy.getSize())))
            score.increaseScore(250 + score.getIncreaseValue());
        else if (candy.getPosition().getX() < candy.getSize() || candy.getPosition().getX() >= getViewWidth() - candy.getSize() || candy.getPosition().getY() < candy.getSize() || candy.getPosition().getY() >= getViewWidth() - candy.getSize())
            score.increaseScore(100 + score.getIncreaseValue());
        else
            score.increaseScore();
        candy.generateCandy(this);
    }

    public boolean isDead() {
        for (int i = 3; i < getLength(); ++i) {
            if (getPositions()[i].getX() == getHead().getX() && getPositions()[i].getY() == getHead().getY()) {
                return true;
            }
        }
        return (getMap().getVertices()[0] > getHead().getX() || getMap().getVertices()[0] > getHead().getY() || getMap().getVertices()[35] < getHead().getX() || getMap().getVertices()[35] < getHead().getY());
    }

    public void reset() {
        setPositions(initPositions, positionLength);
        setSpeed(initSpeed);
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
    int getDirection() {
        return direction;
    }

    /**
     * Set the snake direction
     * @param direction The snake direction
     */
    void setDirection(int direction) {
        if (canChangeDirection) {
            this.direction = direction;
            canChangeDirection = false;
        }
    }

    /**
     * Add a part of the snake.
     * @param position A part of the snake
     */
    private void addPosition(Position position) {
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
    public float getSpeed() {
        return speed;
    }

    /**
     * Set the speed of the snake
     * @param speed The speed of the snake
     */
    public void setSpeed(float speed) {
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
    private void setPositions(Position[] positions, int length) {
        emptyPositions();
        for (int i = 0; i < length; ++i) {
            addPosition(positions[i]);
        }
    }

    public int getMaxLength() {
        return maxLength;
    }
}
