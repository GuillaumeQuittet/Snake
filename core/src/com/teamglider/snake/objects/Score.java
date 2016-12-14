package com.teamglider.snake.objects;

/**
 * Created by Guillaume Quittet on 14/12/16.
 */
public class Score {

    private int score;

    public Score(int score) {
        this.score = score;
    }

    public Score() {
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void increaseScore(int x) {
        score += x;
    }

    public String toString() {
        return Integer.toString(score);
    }
}
