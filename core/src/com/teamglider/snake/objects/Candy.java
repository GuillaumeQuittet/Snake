package com.teamglider.snake.objects;

import com.badlogic.gdx.graphics.Color;
import com.teamglider.snake.helpers.Position;

import java.util.Random;

/**
 * A candy that feed my snake
 * Created by Guillaume Quittet on 13/12/16.
 */
public class Candy {

    private Position position;
    private int size;
    private Color color;
    private Map map;

    /**
     * A new Candy
     *
     * @param size     The size of the square
     * @param position The position of the square
     */
    public Candy(int size, Position position, Map map) {
        this.size = size;
        this.position = position;
        this.map = map;
        color = new Color(1, 1, 1, 1);
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
     * @param position The position of the candy
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
        x = map.getAbscisses()[r1];
        y = map.getOrdonnees()[r2];
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
