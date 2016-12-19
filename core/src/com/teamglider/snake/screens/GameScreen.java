package com.teamglider.snake.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.teamglider.snake.helpers.AssetLoader;
import com.teamglider.snake.helpers.InputHandler;
import com.teamglider.snake.world.GameRenderer;
import com.teamglider.snake.world.GameWorld;

/**
 * GameScreen
 * Created by Guillaume Quittet on 11/12/16.
 */
public class GameScreen implements Screen {

    private GameWorld gameWorld;
    private GameRenderer gameRenderer;

    public GameScreen(int viewWidth, int viewHeight) {
        Gdx.app.log("GameScreen", "Attached");
        gameWorld = new GameWorld(viewWidth);
        gameRenderer = new GameRenderer(gameWorld, viewWidth, viewHeight);
        Gdx.input.setInputProcessor(new InputHandler(gameWorld.getGamePad(), gameRenderer.getCamera()));
    }

    @Override
    public void show() {
        Gdx.app.log("GameScreen", "Show");
    }

    @Override
    public void render(float delta) {
        if (gameWorld.getGamePad().getPause().isPause())
            gameRenderer.render("Pause");
        else {
            gameWorld.update(delta);
            gameRenderer.render("");
        }
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("GameScreen", "Resize");
    }

    @Override
    public void pause() {
        Gdx.app.log("GameScreen", "Pause");
        gameWorld.getGamePad().getPause().setPause(true);
    }

    @Override
    public void resume() {
        Gdx.app.log("GameScreen", "Resume");
    }

    @Override
    public void hide() {
        Gdx.app.log("GameScreen", "Hide");
        gameWorld.getGamePad().getPause().setPause(true);
    }

    @Override
    public void dispose() {
        Gdx.app.log("GameScreen", "Dispose");
        AssetLoader.dispose();
    }
}
