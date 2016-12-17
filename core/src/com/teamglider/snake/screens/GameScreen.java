package com.teamglider.snake.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.teamglider.snake.helpers.AssetLoader;
import com.teamglider.snake.helpers.SnakeInputHandler;
import com.teamglider.snake.world.GameRenderer;
import com.teamglider.snake.world.GameWorld;

/**
 * Created by Guillaume Quittet on 11/12/16.
 */
public class GameScreen implements Screen {

    private GameWorld gameWorld;
    private GameRenderer gameRenderer;

    private boolean isPause;
    private String pauseText;

    public GameScreen(int viewWidth, int viewHeight) {
        Gdx.app.log("GameScreen", "Attached");
        gameWorld = new GameWorld(viewWidth);
        gameRenderer = new GameRenderer(gameWorld, viewWidth, viewHeight);
        isPause = false;
        pauseText = "";
        Gdx.input.setInputProcessor(new SnakeInputHandler(gameWorld.getGamePad(), gameRenderer.getCamera()));
    }

    @Override
    public void show() {
        Gdx.app.log("GameScreen", "Show");
    }

    @Override
    public void render(float delta) {
        if (!isPause) {
            gameWorld.update(delta);
        }
        gameRenderer.render(pauseText);
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("GameScreen", "Resize");
    }

    @Override
    public void pause() {
        Gdx.app.log("GameScreen", "Pause");
        togglePause();
    }

    @Override
    public void resume() {
        Gdx.app.log("GameScreen", "Resume");
        togglePause();
    }

    @Override
    public void hide() {
        Gdx.app.log("GameScreen", "Hide");
    }

    @Override
    public void dispose() {
        Gdx.app.log("GameScreen", "Dispose");
        AssetLoader.dispose();
    }

    public boolean isPause() {
        return isPause;
    }

    public void setPause(boolean pause) {
        isPause = pause;
    }

    public String getPauseText() {
        return pauseText;
    }

    public void setPauseText(String pauseText) {
        this.pauseText = pauseText;
    }

    public void togglePause() {
        if (isPause) {
            setPause(false);
            setPauseText("");
        } else {
            setPause(true);
            setPauseText("Pause");
        }
    }
}
