package com.teamglider.snake.objects;

import com.teamglider.snake.helpers.Position;

import java.util.Random;

/**
 * A candy that feed my snake
 * Created by Guillaume Quittet on 13/12/16.
 */
public class Candy {

    private Position position;
    private int size;

    private int abscisses[];
    private int ordonnees[];

    /**
     * A new Candy
     *
     * @param size     The size of the square
     * @param position The position of the square
     */
    public Candy(int size, Position position) {
        this.size = size;
        this.position = position;
        abscisses = new int[36];
        ordonnees = new int[36];
        for (int i = 0, j = 30; i < 180 && j < 210; i += 5, j += 5) {
            abscisses[i / 5] = i;
            ordonnees[i / 5] = j;
        }
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
        x = abscisses[r1];
        y = ordonnees[r2];
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
