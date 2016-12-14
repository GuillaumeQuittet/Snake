package com.teamglider.snake.world;

import com.teamglider.snake.helpers.Position;
import com.teamglider.snake.objects.Candy;
import com.teamglider.snake.objects.GamePad;
import com.teamglider.snake.objects.Snake;

import java.util.Random;

/**
 * Created by Guillaume Quittet on 11/12/16.
 */
public class GameWorld {

    private GamePad gamePad;
    private int objectSize;
    private Snake snake;
    private Candy candy;
    private int updateCount;

    private int abscisses[];
    private int ordonnees[];

    public GameWorld() {
        objectSize = 5;
        abscisses = new int[36];
        ordonnees = new int[36];
        for (int i = 0, j = 30; i < 180 && j < 210; i += 5, j += 5) {
            abscisses[i / 5] = i;
            ordonnees[i / 5] = j;
        }
        initWorldObjects();
    }

    private void initWorldObjects() {
        updateCount = 0;
        snake = new Snake(objectSize, 80, 10, new Position[]{new Position(100, 50), new Position(105, 50), new Position(110, 50)});
        gamePad = new GamePad(32f, new Position(40f, 250f), snake);
        Position candyPosition = generatePosition();
        candy = new Candy(objectSize, candyPosition);
    }

    public int update(float delta) {
        //Gdx.app.log("GameWorld", "Update");
        updateCount++;
        if (updateCount == snake.getSpeed()) {
            snake.update(delta);
            if (candy.getPosition().equals(snake.getHead())) {
                snake.eatCandy(candy);
                generateCandy();
            }
            if (snake.getLength() > 10 && snake.getLength() < 20)
                snake.setSpeed(7);
            else if (snake.getLength() > 20 && snake.getLength() < 30)
                snake.setSpeed(5);
            else if (snake.getLength() > 30)
                snake.setSpeed(3);
            if (snakeIsDead())
                return 1;
            updateCount = 0;
        }
        return 0;
    }

    private boolean snakeIsDead() {
        for (int i = 3; i < snake.getLength(); ++i) {
            if (snake.getPositions()[i].getX() == snake.getHead().getX() && snake.getPositions()[i].getY() == snake.getHead().getY()) {
                return true;
            }
        }
        if (snake.getHead().getX() < abscisses[0] || snake.getHead().getX() > abscisses[35] || snake.getHead().getY() < ordonnees[0] || snake.getHead().getY() > ordonnees[35]) {
            return true;
        }
        return false;
    }

    private void generateCandy() {
        Position candyPosition = generatePosition();
        candy.setPosition(candyPosition);
    }

    private Position generatePosition() {
        int r1 = new Random().nextInt(36);
        int r2 = new Random().nextInt(36);
        float x = abscisses[r1];
        float y = ordonnees[r2];
        return new Position(x, y);
    }

    public GamePad getGamePad() {
        return gamePad;
    }

    public Snake getSnake() {
        return snake;
    }

    public Candy getCandy() {
        return candy;
    }
}
