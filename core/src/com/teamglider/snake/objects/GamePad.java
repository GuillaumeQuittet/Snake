package com.teamglider.snake.objects;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Rectangle;
import com.teamglider.snake.helpers.Position;

/**
 * The gamepad with the main controls
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

    /**
     * A new gamepad
     *
     * @param size     The size of a key
     * @param position The position of center of the cross
     */
    public GamePad(float size, Position position) {
        this.size = size;
        this.position = position;
        initActionObjects();
    }

    /**
     * Initialize the objects of this class.
     */
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

    /**
     * Add an action of a click
     * @param x The x position of the touch
     * @param y The y position of the touch
     */
    public void onClick(float x, float y) {
        // Cross
        if (y >= rectPad.getY() && y <= rectPad.getY() + rectPad.getHeight()) {
            if (x >= arrowUp.getPosition().getX() && x <= arrowUp.getPosition().getX() + arrowUp.getSize()) {
                if (y >= arrowUp.getPosition().getY() && y <= arrowUp.getPosition().getY() + arrowUp.getSize()) {
                    if (snake.getDirection() != 1)
                        snake.setDirection(3);
                } else if (y >= arrowDown.getPosition().getY() && y <= arrowDown.getPosition().getY() + arrowDown.getSize()) {
                    if (snake.getDirection() != 3)
                        snake.setDirection(1);
                }
            } else if (y >= arrowLeft.getPosition().getY() && y <= arrowLeft.getPosition().getY() + arrowLeft.getSize()) {
                if (x >= arrowLeft.getPosition().getX() && x <= arrowLeft.getPosition().getX() + arrowLeft.getSize()) {
                    if (snake.getDirection() != 0)
                        snake.setDirection(2);
                } else if (x >= arrowRight.getPosition().getX() && x <= arrowRight.getPosition().getX() + arrowRight.getSize()) {
                    if (snake.getDirection() != 2)
                        snake.setDirection(0);
                }
            }
        }
    }

    /**
     * Add an action with a key press event
     * @param keycode The code of the key that has been pressed
     */
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

    /**
     * Return the key size
     * @return The key size
     */
    public float getSize() {
        return size;
    }

    /**
     * Return the center of the cross
     * @return The center of the cross
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Return the right button of the cross
     * @return The right button of the cross
     */
    public ActionKey getArrowRight() {
        return arrowRight;
    }

    /**
     * Return the down button of the cross
     * @return The down button of the cross
     */
    public ActionKey getArrowDown() {
        return arrowDown;
    }

    /**
     * Return the left button of the cross
     * @return The left button of the cross
     */
    public ActionKey getArrowLeft() {
        return arrowLeft;
    }

    /**
     * Return the up button of the cross
     * @return The up button of the cross
     */
    public ActionKey getArrowUp() {
        return arrowUp;
    }

    /**
     * Return the button A of the gampad
     * @return The button A of the gamepad
     */
    public ActionKey getActionButtonA() {
        return actionButtonA;
    }

    /**
     * Return the button B of the gamepad
     * @return The button B of the gamepad
     */
    public ActionKey getActionButtonB() {
        return actionButtonB;
    }

    /**
     * Return the button menu of the gamepad
     * @return The button of the gamepad
     */
    public ActionKey getActionButtonMenu() {
        return actionButtonMenu;
    }

    /**
     * Return the background of the gamepad
     * @return The background of the gamepad
     */
    public Rectangle getRectPad() {
        return rectPad;
    }

    public void attachSnake(Snake snake) {
        this.snake = snake;
    }
}