package com.teamglider.snake.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.teamglider.snake.helpers.InputHandler;
import com.teamglider.snake.world.MenuRenderer;
import com.teamglider.snake.world.MenuWorld;

/**
 * MenuScreen
 * Created by Guillaume Quittet on 15/12/16.
 */
public class MenuScreen implements Screen {

    private MenuWorld menuWorld;
    private MenuRenderer renderer;

    public MenuScreen(int viewWidth, int viewHeight) {
        Gdx.app.log("MenuScreen", "Attached");
        menuWorld = new MenuWorld();
        renderer = new MenuRenderer(menuWorld, viewWidth, viewHeight);
        Gdx.input.setInputProcessor(new InputHandler(menuWorld.getGamePad(), renderer.getCamera()));
    }

    @Override
    public void show() {
        Gdx.app.log("MenuScreen", "Show");
    }

    @Override
    public void render(float delta) {
//        Gdx.app.log("MenuScreen", "Render");
        menuWorld.update();
        renderer.render();
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("MenuScreen", "Resize");
    }

    @Override
    public void pause() {
        Gdx.app.log("MenuScreen", "Pause");
    }

    @Override
    public void resume() {
        Gdx.app.log("MenuScreen", "Resume");
    }

    @Override
    public void hide() {
        Gdx.app.log("MenuScreen", "Hide");
    }

    @Override
    public void dispose() {
        Gdx.app.log("MenuScreen", "Dispose");
    }
}
