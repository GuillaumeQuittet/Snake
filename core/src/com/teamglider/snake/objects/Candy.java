package com.teamglider.snake.objects;

import com.badlogic.gdx.graphics.Color;
import com.teamglider.snake.helpers.Position;

import java.util.Random;

/**
 * A candy that feed my snake
 * Created by Guillaume Quittet on 13/12/16.
 */
public class Candy extends GameObject {

    /**
     * A new Candy
     *
     * @param size     The size of the square
     * @param position The position of the square
     */
    public Candy(int size, Position position) {
        super(size);
        setPosition(position);
        setColor(new Color(1, 1, 1, 1));
    }

    public void generateCandy(Snake snake) {
        Position candyPosition = generatePosition(snake);
        setPosition(candyPosition);
    }

    private Position generatePosition(Snake snake) {
        boolean reGenerate = true;
        float x;
        float y;
        Position position;
        int r1 = new Random().nextInt(36);
        int r2 = new Random().nextInt(36);
        x = super.getMap().getVertices()[r1];
        y = super.getMap().getVertices()[r2];
        position = new Position(x, y);
        for (int i = 0; i < snake.getLength(); i++) {
            if (snake.getPositions()[i].equals(position)) {
                reGenerate = true;
                break;
            } else
                reGenerate = false;
        }
        if (reGenerate)
            position = generatePosition(snake);
        return position;
    }
}
