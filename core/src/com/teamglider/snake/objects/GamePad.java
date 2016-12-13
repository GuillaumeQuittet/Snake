package com.teamglider.snake.objects;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Rectangle;
import com.teamglider.snake.helpers.Position;

/**
 * Created by Guillaume Quittet on 12/12/16.
 */
public class GamePad {

    private float size;
    private Position position;
    private Rectangle rectPad;
    private ActionKey arrowRight;
    private ActionKey arrowDown;
    private ActionKey arrowLeft;
    private ActionKey arrowUp;
    private ActionKey actionButtonA;
    private ActionKey actionButtonB;
    private ActionKey actionButtonMenu;

    private Snake snake;

    public GamePad(float size, Position position, Snake snake) {
        this.size = size;
        this.position = position;
        this.snake = snake;
        initActionObjects();
    }

    private void initActionObjects() {
        rectPad = new Rectangle(0, 210, 180, 320);
        arrowRight = new ActionKey(1, size, new Position(position.getX() + size, position.getY()));
        arrowDown = new ActionKey(2, size, new Position(position.getX(), position.getY() + size));
        arrowLeft = new ActionKey(3, size, new Position(position.getX() - size, position.getY()));
        arrowUp = new ActionKey(0, size, new Position(position.getX(), position.getY() - size));
        actionButtonA = new ActionKey(0, size, new Position(position.getX() + 100, position.getY() - 20));
        actionButtonB = new ActionKey(0, size, new Position(position.getX() + 80, position.getY() + 20));
        actionButtonMenu = new ActionKey(0, size/2.0f, new Position((rectPad.getWidth() - (size/2))/2, 7.5f));
    }

    public void onClick(float x, float y) {
        // Cross
        if (y >= rectPad.getY() && y <= rectPad.getY() + rectPad.getHeight()) {
            if (x >= arrowUp.getPosition().getX() && x <= arrowUp.getPosition().getX() + arrowUp.getSize()) {
                if (y >= arrowUp.getPosition().getY() && y <= arrowUp.getPosition().getY() + arrowUp.getSize()) {
                    if(snake.getDirection() != 1)
                        snake.setDirection(3);
                } else if (y >= arrowDown.getPosition().getY() && y <= arrowDown.getPosition().getY() + arrowDown.getSize()) {
                    if(snake.getDirection() != 3)
                        snake.setDirection(1);
                }
            } else if (y >= arrowLeft.getPosition().getY() && y <= arrowLeft.getPosition().getY() + arrowLeft.getSize()) {
                if (x >= arrowLeft.getPosition().getX() && x <= arrowLeft.getPosition().getX() + arrowLeft.getSize()) {
                    if(snake.getDirection() != 0)
                        snake.setDirection(2);
                } else if (x >= arrowRight.getPosition().getX() && x <= arrowRight.getPosition().getX() + arrowRight.getSize()) {
                    if(snake.getDirection() != 2)
                        snake.setDirection(0);
                }
            }
        }
    }

    public void onKeyPress(int keycode) {
        switch (keycode) {
            case Input.Keys.LEFT:
                if (snake.getDirection() != 0)
                    snake.setDirection(2);
                break;
            case Input.Keys.RIGHT:
                if (snake.getDirection() != 2)
                    snake.setDirection(0);
                break;
            case Input.Keys.UP:
                if (snake.getDirection() != 1)
                    snake.setDirection(3);
                break;
            case Input.Keys.DOWN:
                if (snake.getDirection() != 3)
                    snake.setDirection(1);
                break;
        }
    }

    public float getSize() {
        return size;
    }

    public Position getPosition() {
        return position;
    }

    public ActionKey getArrowRight() {
        return arrowRight;
    }

    public ActionKey getArrowDown() {
        return arrowDown;
    }

    public ActionKey getArrowLeft() {
        return arrowLeft;
    }

    public ActionKey getArrowUp() {
        return arrowUp;
    }

    public ActionKey getActionButtonA() {
        return actionButtonA;
    }

    public ActionKey getActionButtonB() {
        return actionButtonB;
    }

    public ActionKey getActionButtonMenu() {
        return actionButtonMenu;
    }

    public Rectangle getRectPad() {
        return rectPad;
    }
}