package com.teamglider.snake.helpers;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.teamglider.snake.objects.GamePad;

/**
 * Created by Guillaume Quittet on 11/12/16.
 */
public class SnakeInputHandler implements InputProcessor {

    private GamePad gamePad;
    private OrthographicCamera camera;
    private Vector3 touch;

    public SnakeInputHandler(GamePad gamePad, OrthographicCamera camera) {
        this.gamePad = gamePad;
        this.camera = camera;
        touch = new Vector3();
    }

    @Override
    public boolean keyDown(int keycode) {
        gamePad.onKeyPress(keycode);
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        camera.unproject(touch.set(screenX, screenY, 0));
        gamePad.onClick(touch.x, touch.y);
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
