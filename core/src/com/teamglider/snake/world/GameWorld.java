package com.teamglider.snake.world;

import com.badlogic.gdx.graphics.Color;
import com.teamglider.snake.helpers.Position;
import com.teamglider.snake.objects.Candy;
import com.teamglider.snake.objects.GamePad;
import com.teamglider.snake.objects.Score;
import com.teamglider.snake.objects.Snake;

/**
 * GameWorld class
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

    public GameWorld(int viewWidth) {
        this.viewWidth = viewWidth;
        objectSize = 5;
        score = new Score(5);
        initWorldObjects();
    }

    private void initWorldObjects() {
        updateCount = 0;
        snake = new Snake(objectSize, 80, 1, new Position[]{new Position(85, 85), new Position(90, 85), new Position(95, 85)}, 3);
        snake.initMap(viewWidth);
        gamePad = com.teamglider.snake.Snake.gamePad;
        gamePad.attachObject(snake);
        candy = new Candy(objectSize, new Position(0, 0));
        candy.setColor(new Color(1, 0, 0, 1));
        candy.initMap(viewWidth);
        candy.generateCandy(snake);
    }

    public void update(float delta) {
        //Gdx.app.log("GameWorld", "Update");
        updateCount++;
        if (updateCount == ((int) (1f / snake.getSpeed() * 20))) {
            snake.update(delta);
            if (candy.getPosition().equals(snake.getHead()))
                snake.eatCandy(candy, score);
            float speed = 1.0f;
            int scoreValue = 0;
            for (int i = 5; i < snake.getMaxLength(); i += 5) {
                speed += 0.5f;
                scoreValue += 10;
                if (snake.getLength() >= i && snake.getLength() < i + 5) {
                    snake.setSpeed(speed);
                    score.setIncreaseValue(scoreValue);
                }
            }
            if (snake.isDead()) {
                resetGame();
            }
            updateCount = 0;
        }
    }

    private void resetGame() {
        snake.reset();
        score.reset();
        candy.generateCandy(snake);
    }

    public GamePad getGamePad() {
        return gamePad;
    }

    public Snake getSnake() {
        return snake;
    }

    Candy getCandy() {
        return candy;
    }

    Score getScore() {
        return score;
    }
}
