package com.teamglider.snake;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.teamglider.snake.helpers.AssetLoader;
import com.teamglider.snake.screens.GameScreen;

public class Snake extends Game {

    private int viewWidth, viewHeight;

    public Snake(int width, int height) {
        viewWidth = width / 2;
        viewHeight = height / 2;
    }

    @Override
	public void create() {
        Gdx.app.log("Snake", "Game created");
        AssetLoader.load();
        setScreen(new GameScreen(viewWidth, viewHeight));
    }
}