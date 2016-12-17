package com.teamglider.snake.world;

import com.teamglider.snake.objects.GamePad;
import com.teamglider.snake.objects.Menu;
import com.teamglider.snake.objects.Score;

import java.io.File;

/**
 * Created by Guillaume Quittet on 15/12/16.
 */
public class MenuWorld {

    private GamePad gamePad;
    private Menu menu;
    private File currentGame;
    private Score score;

    public MenuWorld() {
        currentGame = new File("Saves/sav.snk");
        File scoreFile = new File("Saves/score.snk");
        if (currentGame.exists())
            menu = new Menu(new String[]{"New game", "Continue game", "Options", "About", "Exit"});
        else
            menu = new Menu(new String[]{"New game", "Options", "About", "Exit"});
        if (scoreFile.exists())
            score = new Score(0);
        else
            score = new Score(0);
        initMenuObjects();
    }

    public void update() {

    }

    private void initMenuObjects() {
        gamePad = com.teamglider.snake.Snake.gamePad;
    }

    public GamePad getGamePad() {
        return gamePad;
    }

    public void setGamePad(GamePad gamePad) {
        this.gamePad = gamePad;
    }

    public Score getScore() {
        return score;
    }
}
