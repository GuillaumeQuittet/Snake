package com.teamglider.snake.objects;

/**
 * Pause the game
 * Created by Guillaume Quittet on 19/12/16.
 */
public class Pause {

    private boolean isPause;

    Pause(boolean isPause) {
        this.isPause = isPause;
    }

    public boolean isPause() {
        return isPause;
    }

    public void setPause(boolean pause) {
        isPause = pause;
    }
}
