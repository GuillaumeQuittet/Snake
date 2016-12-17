package com.teamglider.snake.world;

import com.teamglider.snake.helpers.Position;
import com.teamglider.snake.objects.*;

/**
 * Created by Guillaume Quittet on 11/12/16.
 */
public class GameWorld {

    public static Snake snake;
    private int viewWidth;
    private GamePad gamePad;
    private int objectSize;
    private Candy candy;
    private int updateCount;

    private Score score;

    private Map map;

    public GameWorld(int viewWidth) {
        this.viewWidth = viewWidth;
        objectSize = 5;
        score = new Score();
        initWorldObjects();
    }

    private void initWorldObjects() {
        updateCount = 0;
        snake = new Snake(objectSize, 80, 1, new Position[]{new Position(100, 50), new Position(105, 50), new Position(110, 50)});
        map = new Map(viewWidth, snake.getSize());
        gamePad = com.teamglider.snake.Snake.gamePad;
        gamePad.attachSnake(snake);
        candy = new Candy(objectSize, new Position(0, 0), map);
        candy.generateCandy(snake);
    }

    public void update(float delta) {
        //Gdx.app.log("GameWorld", "Update");
        updateCount++;
        if (updateCount == ((int) (1f / snake.getSpeed() * 20))) {
            snake.update(delta);
            if (candy.getPosition().equals(snake.getHead())) {
                snake.eatCandy(candy);
                if (candy.getPosition().getX() <= candy.getSize() || candy.getPosition().getX() >= viewWidth - candy.getSize() || candy.getPosition().getY() - 30 <= candy.getSize() || candy.getPosition().getY() - 30 >= viewWidth - candy.getSize())
                    score.increaseScore(150);
                else
                    score.increaseScore(50);
                candy.generateCandy(snake);
            }
            float speed = 1.0f;
            for (int i = 5; i < snake.getMaxLength(); i += 5) {
                speed += 0.5f;
                if (snake.getLength() >= i && snake.getLength() < i + 5)
                    snake.setSpeed(speed);
            }
            if (snakeIsDead()) {
                snake.setPositions(new Position[]{new Position(100, 50), new Position(105, 50), new Position(110, 50)}, 3);
                snake.setSpeed(1);
                score.setScore(0);
                candy.generateCandy(snake);
            }
            updateCount = 0;
        }
    }

    private boolean snakeIsDead() {
        for (int i = 3; i < snake.getLength(); ++i) {
            if (snake.getPositions()[i].getX() == snake.getHead().getX() && snake.getPositions()[i].getY() == snake.getHead().getY()) {
                return true;
            }
        }
        if (snake.getHead().getX() < map.getAbscisses()[0] || snake.getHead().getX() > map.getAbscisses()[35] || snake.getHead().getY() < map.getOrdonnees()[0] || snake.getHead().getY() > map.getOrdonnees()[35]) {
            return true;
        }
        return false;
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

    public Score getScore() {
        return score;
    }
}
