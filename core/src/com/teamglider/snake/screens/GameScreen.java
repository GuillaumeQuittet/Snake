package com.teamglider.snake.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.teamglider.snake.helpers.AssetLoader;
import com.teamglider.snake.helpers.InputHandler;
import com.teamglider.snake.world.GameRenderer;
import com.teamglider.snake.world.GameWorld;

/**
 * Created by Guillaume Quittet on 11/12/16.
 */
public class GameScreen implements Screen {

    private GameWorld gameWorld;
    private GameRenderer gameRenderer;

    public GameScreen() {
        Gdx.app.log("GameScreen", "Attached");
        gameWorld = new GameWorld();
        gameRenderer = new GameRenderer(gameWorld);
        Gdx.input.setInputProcessor(new InputHandler(gameWorld.getGamePad(), gameRenderer.getCamera()));
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if(gameWorld.update(delta) == 1) {
            dispose();
            Gdx.app.exit();
        }
        gameRenderer.render();
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("GameScreen", "Resize");
    }

    @Override
    public void pause() {
        Gdx.app.log("GameScreen", "Pause");
    }

    @Override
    public void resume() {
        Gdx.app.log("GameScreen", "Resume");
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
}
