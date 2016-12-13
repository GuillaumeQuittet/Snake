package com.teamglider.snake;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.teamglider.snake.helpers.AssetLoader;
import com.teamglider.snake.screens.GameScreen;

public class Snake extends Game {

    @Override
	public void create() {
        Gdx.app.log("Snake", "Game created");
        AssetLoader.load();
        setScreen(new GameScreen());
    }
}