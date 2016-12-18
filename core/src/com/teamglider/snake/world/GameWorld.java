package com.teamglider.snake.world;

import com.teamglider.snake.helpers.Position;
import com.teamglider.snake.objects.*;

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

    private Map map;

    public GameWorld(int viewWidth) {
        this.viewWidth = viewWidth;
        objectSize = 5;
        score = new Score(5);
        initWorldObjects();
    }

    private void initWorldObjects() {
        updateCount = 0;
        snake = new Snake(objectSize, 80, 1, new Position[]{new Position(85, 85), new Position(90, 85), new Position(95, 85)});
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
                if ((candy.getPosition().getX() < candy.getSize() && (candy.getPosition().getY() < candy.getSize() || candy.getPosition().getY() >= viewWidth - candy.getSize())) || (candy.getPosition().getX() >= viewWidth - candy.getSize() && (candy.getPosition().getY() < candy.getSize() || candy.getPosition().getY() >= viewWidth - candy.getSize())))
                    score.increaseScore(250 + score.getIncreaseValue());
                else if (candy.getPosition().getX() < candy.getSize() || candy.getPosition().getX() >= viewWidth - candy.getSize() || candy.getPosition().getY() < candy.getSize() || candy.getPosition().getY() >= viewWidth - candy.getSize())
                    score.increaseScore(100 + score.getIncreaseValue());
                else
                    score.increaseScore();
                candy.generateCandy(snake);
            }
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
            if (snakeIsDead()) {
                resetGame();
            }
            updateCount = 0;
        }
    }

    private void resetGame() {
        snake.setPositions(new Position[]{new Position(100, 50), new Position(105, 50), new Position(110, 50)}, 3);
        snake.setSpeed(1);
        score.setScore(0);
        score.setIncreaseValue(5);
        candy.generateCandy(snake);
    }

    private boolean snakeIsDead() {
        for (int i = 3; i < snake.getLength(); ++i) {
            if (snake.getPositions()[i].getX() == snake.getHead().getX() && snake.getPositions()[i].getY() == snake.getHead().getY()) {
                return true;
            }
        }
        return (map.getVertices()[0] > snake.getHead().getX() || map.getVertices()[0] > snake.getHead().getY() || map.getVertices()[35] < snake.getHead().getX() || map.getVertices()[35] < snake.getHead().getY());
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
